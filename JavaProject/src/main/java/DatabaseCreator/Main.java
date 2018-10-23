package DatabaseCreator;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DatabaseCreator.beans.City;
import DatabaseCreator.beans.CountryMain;
import DatabaseCreator.tables.CityManager;
import DatabaseCreator.tables.CountryMainManager;
import DatabaseCreator.util.ConnectionManager;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 * Launches database creator.
 *
 * <P>Creates database from country data
 *
 * @author Aleksandr Strizhevskiy
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {



        ConnectionManager.getInstance();

        //CountryMainManager.displayAllRows();
        //CityManager.displayAllRows();

        //Source project folder where country files are stored
        //Change to your own directory
        String projectFolder = "C:/Users/Aleksandr/Documents/ParcingFactbook/";
        String source = projectFolder + "Countries/";

        File coutryDir = new File(source);
        File[] files = coutryDir.listFiles();


        //Excludes comparison data from the output
        //String forbidenText = "country comparison to the world";

        //Loops through all the files in the folder
        for (File file : files) {

            File input = new File(source + file.getName());
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements classes = doc.select("[class]");

            CountryMain countryBean = new CountryMain();

            Element previous = null;
            String countryCode = null;
            String countryName = null;
            String region = null;
            String sectionTitle = null;
            String introduction = "";

            //Pulls data from relevant html tags
            for( Element el : classes){
                //TODO: Make sure all parts of country name are capitalized
                if(el.className().contains("printHeader")){
                    String[] parts = el.text().split("::");
                    region = parts[0].trim();
                    countryName	= parts[1].trim();
                    countryName = countryName.charAt(0) +
                                  countryName.substring(1).toLowerCase();
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
                        default:
                            ;
                    }
                    if(previous.className().contains("_light") &&
                       previous.text().contains("Major urban areas")){

                        ArrayList<City> cityBeans = processCities(el.text().split(";"), countryCode);

                        for(City city : cityBeans)
                            CityManager.insert(city);

                    }

                }

//                if(el.className().equals("countryName")){
//                    countryName = el.text();
//                }
//
//                if(el.className().contains("question ")){
//                    out.write("\n\n\n");
//                    out.write(el.text().split(":")[0].trim() + ":\n");
//                }
//
//                if(el.className().contains("_light")){
//                    out.write( "\n\t" + el.text() + "\n\t\t" );
//                }
//
//                if(el.className().equals("category") && !el.text().contains(forbidenText)){
//                    out.write( "\n\t\t" + el.text() + " ");
//                }
//
//                if(el.className().equals("category_data")){
//
//                    if(previous.className().equals("category") && previous.text().contains(forbidenText)){
//                        continue;
//                    }
//
//                    else if(previous.className().equals("category_data")){
//                        out.write("\t\t" + el.text() + "\n");
//                    }
//
//                    else{
//                        out.write(el.text() + "\n");
//                    }
//                }
//
                previous = el;

            }
            countryBean.setCountryCode(countryCode);
            countryBean.setCountryName(countryName);
            countryBean.setRegion(region);
            countryBean.setIntroduction(introduction);
            CountryMainManager.insert(countryBean);


        }

        System.out.println("Parcing Complete!");


        ConnectionManager.getInstance().close();
    }

    private static ArrayList<City> processCities( String[] cities, String countryCode){

        ArrayList<City> cityBeans = new ArrayList<>();

        for( String city : cities){

            City cityBean = new City();
            cityBean.setCountryCode(countryCode);
            String[] cityData = city.trim().split(" ");

            //Determines City Name
            //TODO: Make sure city name is not getting chopped off
            if (Pattern.matches("[a-zA-Z]+", Character.toString(cityData[1].charAt(0)) )){
                cityBean.setCityName(cityData[0] + " " + cityData[1]);
            }else
                cityBean.setCityName(cityData[0]);

            //Checks if a capital
            if( cityData[1].equals("(capital)") )
                cityBean.setCapital(true);
            else
                cityBean.setCapital(false);

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
                }
                if( number != 0.0)
                    break;
            }
            cityBeans.add(cityBean);
        }
        return cityBeans;
    }


}
