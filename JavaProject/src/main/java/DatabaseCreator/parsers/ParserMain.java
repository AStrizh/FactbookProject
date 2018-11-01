package DatabaseCreator.parsers;


import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DatabaseCreator.beans.Border;
import DatabaseCreator.beans.City;
import DatabaseCreator.beans.CountryMain;
import DatabaseCreator.beans.Geography;
import DatabaseCreator.tables.BorderManager;
import DatabaseCreator.tables.CityManager;
import DatabaseCreator.tables.CountryMainManager;
import DatabaseCreator.util.ConnectionManager;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class ParserMain {

    public static void mainParser( File countryFile) throws IOException {


        //File input = new File(source + file.getName());
        Document doc = Jsoup.parse(countryFile, "UTF-8");
        Elements classes = doc.select("[class]");

        CountryMain countryBean = new CountryMain();

        Element previous = null;
        String countryCode = null;
        String countryName = "";
        String region = "";
        String sectionTitle = "";
        String introduction = "";

        //Pulls data from relevant html tags
        for( Element el : classes){

            if(el.className().contains("printHeader")){
                String[] parts = el.text().split("::");
                region = parts[0].trim();

                String tempName = parts[1].trim();
                if(parts[1].trim().contains(" "))
                    countryName = spacedCountryName(tempName);
                else if (parts[1].trim().contains("-"))
                    countryName = hyphenedCountryName(tempName);
                else
                    countryName = singleCountryName(tempName);

                //Identifies currently parsing country
                //System.out.println("*******"+countryName+"*******");
            }

            if(el.className().contains("question ")){
                sectionTitle = el.attributes().get("sectiontitle");
                if(countryCode == null)
                    countryCode = el.attributes().get("ccode").toUpperCase();
            }


            if(el.className().equals("category_data")){

                switch(sectionTitle){
                    case "Introduction":
                        introduction = introduction + el.text() + "\n";
                        break;
                    case "Geography":
                        if(previous.className().contains("category")){
                            if(previous.text().contains("border countries")){

                                String borders = removeParentheses(el.text()).trim();
                                ArrayList<Border> borderNations = processBorders(
                                        borders.split(" km ,| km,| km"), countryCode);

                                for(Border border : borderNations)
                                    BorderManager.insert(border);
                            }
                        }

                        switch (previous.text()){
                            case "Geographic coordinates:":
                                //System.out.println( "Geographic coordinates: " + el.text());
                                break;
                            case "Coastline:":
                                //System.out.println("Coastline: " + el.text());
                                break;
                            case "Irrigated land:":
                                //System.out.println("Irrigated land: " + el.text());
                                break;


                            default:
                                ;
                        }
                        break;
                    case "People and Society":
                        if(previous.className().contains("_light") &&
                                previous.text().contains("Major urban areas")){

                            ArrayList<City> cityBeans = processCities(el.text().split(";"), countryCode);
                            for(City city : cityBeans)
                                CityManager.insert(city);
                        }
                        break;
                    default:
                        ;
                }



            }

            previous = el;

        }
        countryBean.setCountryCode(countryCode);
        countryBean.setCountryName(countryName);
        countryBean.setRegion(region);
        countryBean.setIntroduction(introduction);
        CountryMainManager.insert(countryBean);
    }

    private static String singleCountryName(String tempName){
        return tempName.charAt(0) + tempName.substring(1).toLowerCase();
    }

    private static String spacedCountryName(String tempName){
        String countryName = "";

        String[] nameParts	= tempName.split(" ");
        for(String part : nameParts){
            if(part.charAt(0) == '(')
                countryName = countryName + " (" + part.charAt(1) + part.substring(2).toLowerCase();
            else
                countryName = countryName + " " + part.charAt(0) + part.substring(1).toLowerCase();
        }

        return countryName.trim();
    }

    private static String hyphenedCountryName(String tempName){
        String countryName = "";

        String[] nameParts	= tempName.split("-");

        countryName = nameParts[0].charAt(0) + nameParts[0].substring(1).toLowerCase()
                + "-" + nameParts[1].charAt(0) + nameParts[1].substring(1).toLowerCase();

        return countryName;
    }


    private static ArrayList<Border> processBorders(String[] borders, String countryCode){
        ArrayList<Border> borderNations = new ArrayList<>();

        for(String border : borders){
            String[] borderData = border.trim().split("  | ");

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (Pattern.matches("[a-zA-Z]+", Character.toString(borderData[i].charAt(0)))){
                sb.append(" " + borderData[i]);
                i++;
            }
            String borderName = sb.toString();

            double borderKM = 0.0;
            try{
                borderKM = Double.parseDouble(borderData[i].replace(",",""));
            }catch(NumberFormatException e) {
                System.out.println("NumberFormatException: " + borderData[i]);

            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of bounds! " + countryCode);
            }

            if(!borderNations.isEmpty() &&
                              borderNations.get(borderNations.size()-1).getBorderCountry().equals(borderName) ){

                borderNations.get(borderNations.size()-1).setBorderLength(
                        borderNations.get(borderNations.size()-1).getBorderLength() + borderKM);

            } else {
                Border borderBean = new Border();
                borderBean.setCountryCode(countryCode);
                borderBean.setBorderCountry(borderName);
                borderBean.setBorderLength(borderKM);
                borderNations.add(borderBean);
            }
        }

        return borderNations;
    }

    private static ArrayList<City> processCities( String[] cities, String countryCode){

        ArrayList<City> cityBeans = new ArrayList<>();

        for( String city : cities){

            City cityBean = new City();
            cityBean.setCountryCode(countryCode);
            String[] cityData = city.trim().split(" ");

            //Determines City Name
            StringBuilder sb = new StringBuilder();
            for(String str : cityData){
                if (Pattern.matches("[a-zA-Z]+", Character.toString(str.charAt(0)) )){
                    sb.append(" " + str);
                }else
                    break;
            }
            cityBean.setCityName(sb.toString().trim());

            //Checks if a capital
            cityBean.setCapital(false);
            for(String str : cityData){
                if(str.equals("(capital)"))
                    cityBean.setCapital(true);
            }

            double number = 0;
            for(int i = 1; i<cityData.length; i++){
                try {
                    number = Double.parseDouble(cityData[i].replace(",",""));
                    if( i+1 < cityData.length && cityData[i+1].equals("million")){
                        number = number * 1000000;
                    }
                    cityBean.setPopulation((int)number);
                }
                catch(NumberFormatException e) {
                    //Should ignore failed attempts
                }
                if( number != 0.0)
                    break;
            }
            cityBeans.add(cityBean);
        }
        return cityBeans;
    }

//    private static String removeParentheses(String str){
//
//        StringBuilder br = new StringBuilder();
//        //int flag = 0;
//
//        for(int i = 0; i<str.length(); i++){
//            if(str.charAt(i) == '('){
//                while (str.charAt(i) != ')')
//                    i++;
//                i++;
//            }
//            if(i<str.length())
//                br.append(str.charAt(i));
//        }
//        return br.toString();
//    }

    private static String removeParentheses(String str){

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        for(int i = 0; i<str.length(); i++){
            //char c = str.charAt(i);
            switch(str.charAt(i)){
                case '(':
                    flag = 1;
                    continue;
                case ')':
                    flag = 0;
                    continue;
            }
            if(flag==0)
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
