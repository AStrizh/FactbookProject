package DatabaseCreator.parsers;


import java.io.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import DatabaseCreator.beans.*;
import DatabaseCreator.tables.*;
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
        Geography geoBean = new Geography();
        Society societyBean = new Society();

        Element previous = null;
        String countryCode = null;
        String countryName = "";
        String region = "";
        String sectionTitle = "";
        String categoryTitle = "";
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
                System.out.println("*******"+countryName+"*******");
            }

            if(el.className().contains("question ")){
                sectionTitle = el.attributes().get("sectiontitle");
                if(countryCode == null)
                    countryCode = el.attributes().get("ccode").toUpperCase();
            }

            if(el.className().contains("_light")){
                categoryTitle = el.text();
            }


            if(el.className().equals("category_data")){

                switch(sectionTitle){
                    case "Introduction":
                        introduction = introduction + el.text() + "\n";
                        break;
                    case "Geography":
                        geoBean.setCountryCode(countryCode);

                        if(categoryTitle.equals("Land boundaries:") && previous.text().equals("total:"))
                            geoBean.setLandBoundaries(createDouble(el.text().split(" ")[0]));


                        if(previous.className().contains("category")){
                            if(previous.text().contains("border countries")){

                                String borders = removeParentheses(el.text()).trim();
                                ArrayList<Border> borderNations = processBorders(
                                        borders.split(" km ,| km,| km"), countryCode);

                                for(Border border : borderNations)
                                    BorderManager.insert(border);
                            }
                        }

                        if(el.text().contains("border countries"))
                            System.out.println(previous.text());

                        if( el.text().contains("lowest point:")){
                            String[] response = processElevation(removeParentheses(el.text()));
                            geoBean.setLowestPointName(response[0]);
                            geoBean.setLowestPointDistance(createDouble(response[1]));
                        }

                        if( el.text().contains("highest point:")){
                            String[] response = processElevation(removeParentheses(el.text()));
                            geoBean.setHighestPointName(response[0]);
                            geoBean.setHighestPointDistance(createDouble(response[1]));
                        }

                        switch (previous.text()){
                            case "Geographic coordinates:":
                                String[] coords = parseGeoCords(el.text());
                                geoBean.setLat(createDouble(coords[0]));
                                geoBean.setLng(createDouble(coords[1]));
                                break;
                            case "Coastline:":
                                geoBean.setCoastline(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Irrigated land:":
                                geoBean.setIrrigatedLand(createDouble(el.text().split(" ")[0]));
                                break;
                            case "land:":
                                geoBean.setLandArea(createDouble(el.text().split(" ")[0]));
                                break;
                            case "water:":
                                geoBean.setWaterArea(createDouble(el.text().split(" ")[0]));
                                break;
                            case "mean elevation:":
                                geoBean.setMeanElevation(createDouble(el.text().split(" ")[0]));
                                break;
                            default:
                                ;
                        }
                        break;
                    case "People and Society":
                        societyBean.setCountryCode(countryCode);

                        if(categoryTitle.contains("Major urban areas")){

                            ArrayList<City> cityBeans = processCities(el.text().split(";"), countryCode);
                            for(City city : cityBeans)
                                CityManager.insert(city);
                        }

                        switch (categoryTitle){
                            case "Infant mortality rate:":
                                if (previous.text().equals("male:"))
                                    societyBean.setInfantMaleMortalityRatePer1K(createDouble(el.text().split(" ")[0]));
                                else if (previous.text().equals("female:"))
                                    societyBean.setInfantFemaleMortalityRatePer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Life expectancy at birth:":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleLifeExpectancy(createDouble(el.text().split(" ")[0]));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleLifeExpectancy(createDouble(el.text().split(" ")[0]));
                                break;
                            case "School life expectancy (primary to tertiary education):":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleSchoolLifeExpectancy(createInt(el.text().split(" ")[0]));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleSchoolLifeExpectancy(createInt(el.text().split(" ")[0]));
                                break;
                            case "Literacy:":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleLiteracy( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleLiteracy( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                break;
                            case "Unemployment, youth ages 15-24:":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleUnemployment( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleUnemployment( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                break;
                        }


//                        if(categoryTitle.equals("Infant mortality rate:") && previous.text().equals("male:"))
//                            societyBean.setInfantMaleMortalityRatePer1K(createDouble(el.text().split(" ")[0]));
//                        if(categoryTitle.equals("Infant mortality rate:") && previous.text().equals("female:"))
//                            societyBean.setInfantFemaleMortalityRatePer1K(createDouble(el.text().split(" ")[0]));
//
//                        if(categoryTitle.equals("Life expectancy at birth:") && previous.text().equals("male:"))
//                            societyBean.setMaleLifeExpectancy(createDouble(el.text().split(" ")[0]));
//                        if(categoryTitle.equals("Life expectancy at birth:") && previous.text().equals("female:"))
//                            societyBean.setFemaleLifeExpectancy(createDouble(el.text().split(" ")[0]));
//
//                        if(categoryTitle.equals("Literacy:") && previous.text().equals("male:"))
//                            societyBean.setMaleLiteracy( createDouble(
//                                    el.text().split(" ")[0].replace("%","") ));
//
//                        if(categoryTitle.equals("Literacy:") && previous.text().equals("female:"))
//                            societyBean.setFemaleLiteracy( createDouble(
//                                    el.text().split(" ")[0].replace("%","") ));
//
//                        if(categoryTitle.equals("School life expectancy (primary to tertiary education):")
//                                && previous.text().equals("male:"))
//                            societyBean.setMaleSchoolLifeExpectancy( createInt(
//                                    el.text().split(" ")[0] ));
//
//                        if(categoryTitle.equals("School life expectancy (primary to tertiary education):")
//                                && previous.text().equals("female:"))
//                            societyBean.setFemaleSchoolLifeExpectancy( createInt(
//                                    el.text().split(" ")[0] ));
//
//                        if(categoryTitle.equals("Unemployment, youth ages 15-24:") && previous.text().equals("male:"))
//                            societyBean.setMaleUnemployment( createDouble(
//                                    el.text().split(" ")[0].replace("%","") ));
//                        if(categoryTitle.equals("Unemployment, youth ages 15-24:") && previous.text().equals("female:"))
//                            societyBean.setFemaleUnemployment( createDouble(
//                                    el.text().split(" ")[0].replace("%","") ));



                        switch (previous.text()){
                            case "Population:":
                                if(countryName.equals("Zambia"))
                                    societyBean.setPopulation(15972000);
                                else
                                    societyBean.setPopulation(createInt(removeParentheses(el.text())));
                                break;
                            case "0-14 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale0_14(stats[0]);
                                    societyBean.setFemale0_14(stats[1]);
                                }
                                break;
                            case "15-24 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale15_24(stats[0]);
                                    societyBean.setFemale15_24(stats[1]);
                                }
                                break;
                            case "25-54 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale25_54(stats[0]);
                                    societyBean.setFemale25_54(stats[1]);
                                }
                                break;
                            case "55-64 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale55_64(stats[0]);
                                    societyBean.setFemale55_64(stats[1]);
                                }
                                break;
                            case "65 years and over:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale65(stats[0]);
                                    societyBean.setFemale65(stats[1]);
                                }
                                break;
                            case "Population growth rate:":
                                societyBean.setPopulationGrowthRate( createDouble(
                                        el.text().split(" ")[0].replace("%","")
                                ));
                                break;
                            case "Education expenditures:":
                                societyBean.setEducationExpenditures( createDouble(
                                        el.text().split(" ")[0].replace("%","")
                                ));
                                break;
                            case "Birth rate:":
                                societyBean.setBirthRatePer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Death rate:":
                                societyBean.setDeathRatePer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Total fertility rate:":
                                societyBean.setChildrenBornPerWoman(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Net migration rate:":
                                societyBean.setNetMigrationRate(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Mother's mean age at first birth:":
                                societyBean.setMotherMeanAgeAtFirstBirth(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Maternal mortality rate:":
                                societyBean.setMaternalMortalityRatePer100K(createInt(el.text().split(" ")[0]));
                                break;
                            case "degree of risk:":
                                societyBean.setInfectiousDiseasesRisk(el.text());
                                break;
                            case "Contraceptive prevalence rate:":
                                societyBean.setContraceptivePrevalencePCT( createDouble(
                                        removeParentheses(el.text().replace("%","")) ) );
                                break;
                            case "Health expenditures:":
                                societyBean.setHealthExpenditurePCT( createDouble(
                                        el.text().split(" ")[0].replace("%","")) );
                                break;
                            case "Physicians density:":
                                societyBean.setPhysiciansPer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Hospital bed density:":
                                societyBean.setHospitalBedPer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            default:
                                ;

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

        GeographyManager.insert(geoBean);
        SocietyManager.insert(societyBean);
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


    private static String[] processElevation(String elevation){
        String[] elevArray = elevation.split("  | ");

        StringBuilder sb = new StringBuilder();
        int i = 2;

        //Avoids issue where the elevation has a numbered name
        if(Pattern.matches("[0-9]", Character.toString(elevArray[2].charAt(0)))){
            sb.append(elevArray[2]);
            i++;
        }

        while (!Pattern.matches("[0-9\\-]", Character.toString(elevArray[i].charAt(0)))){
            sb.append(" " + elevArray[i]);
            i++;
        }

        String elevName = sb.toString().trim();
        //System.out.println(elevName);

        //System.out.println(elevArray[i]);

        return new String[]{elevName,elevArray[i]};
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

    private static String removeParentheses(String str){

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        for(int i = 0; i<str.length(); i++){
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

    private static String extractParentheses(String str){

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        for(int i = 0; i<str.length(); i++){
            switch(str.charAt(i)){
                case '(':
                    flag = 1;
                    continue;
                case ')':
                    return sb.toString();
            }
            if(flag==1)
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static String[] parseGeoCords(String coordinates){
        String[] tempCoord = coordinates.split(",");
        String[] lat = tempCoord[0].trim().split(" ");
        String[] lng = tempCoord[1].trim().split(" ");

        StringBuilder sb = new StringBuilder();

        if(lat[2].equals("S"))
            sb.append("-");

        sb.append(lat[0] + "." + lat[1] + " ");

        if(lng[2].equals("W"))
            sb.append("-");

        sb.append(lng[0] + "." + lng[1]);

        return new String[]
                {(lat[2].equals("S") ? "-" : "") + lat[0] + "." + lat[1],
                 (lng[2].equals("W") ? "-" : "") + lng[0] + "." + lng[1]};
    }

    private static double createDouble( String number){
        double result = 0.0;
        try {
            result = Double.parseDouble(number.replace(",",""));
        }
        catch(NumberFormatException e) {
            //System.out.println(number + " could not be formatted to double");
        }

        return result;
    }

    private static int createInt(String number){
        int result = 0;

        try{
            double temp = Double.parseDouble(number.replace(",",""));
            temp = Math.round(temp);
            result = (int)temp;
        }catch (NumberFormatException e){
            //System.out.println(number + " could not be formatted to integer");
        }
        return result;
    }

    private static int[] ageStrucProcessing(String popData){
        String[] stats = extractParentheses(popData).split("/");
        return new int[]{
                createInt(stats[0].split(" ")[1]),
                createInt(stats[1].split(" ")[1])
        };
    }
}
