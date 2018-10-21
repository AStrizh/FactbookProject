package FactbookParser;


import java.io.*;
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

/**
 * Country txt creator.
 *
 * <P>Parses print_[countryname].html files from the CIA Factbook into txt files.
 *
 * @author Aleksandr Strizhevskiy
 * @version 1.0
 */
public class FBParser {

    public static void main(String[] args) throws IOException {

        //Source project folder where country files are stored
        //Change to your own directory
        String projectFolder = "C:/Users/Aleksandr/Documents/ParcingFactbook/";
        String source = projectFolder + "Countries/";

        File coutryDir = new File(source);
        File[] files = coutryDir.listFiles();

        //Excludes comparison data from the output
        String forbidenText = "country comparison to the world";

        //Loops through all the files in the folder
        for (File file : files) {

            File input = new File(source + file.getName());
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements classes = doc.select("[class]");

            //Creates a temp country file to write data to
            File output = new File(projectFolder + "output/newCountryFile.txt");
            FileWriter out = new FileWriter(output);

            Element previous = null;
            String countryName = "";

            //Pulls data from relevant html tags
            for( Element el : classes){

                if(el.className().equals("countryName")){
                    countryName = el.text();
                }

                if(el.className().contains("question ")){
                    out.write("\n\n\n");
                    out.write(el.text().split(":")[0].trim() + ":\n");
                }

                if(el.className().contains("_light")){
                    out.write( "\n\t" + el.text() + "\n\t\t" );
                }

                if(el.className().equals("category") && !el.text().contains(forbidenText)){
                    out.write( "\n\t\t" + el.text() + " ");
                }

                if(el.className().equals("category_data")){

                    if(previous.className().equals("category") && previous.text().contains(forbidenText)){
                        continue;
                    }

                    else if(previous.className().equals("category_data")){
                        out.write("\t\t" + el.text() + "\n");
                    }

                    else{
                        out.write(el.text() + "\n");
                    }
                }

                previous = el;

            }

            if (out != null) {
                out.close();
            }

            //Renames file to country name
            File completeFile = new File(projectFolder + "output/newCountryFile.txt");
            File newFile = new File(projectFolder + "output/" + countryName + ".txt");
            completeFile.renameTo(newFile);
        }

        System.out.println("Parcing Complete!");
    }
}
