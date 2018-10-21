package FactbookParser;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.Hashtable;

public class FBParser {

    public static void main(String[] args) throws IOException {

        String source = "C:/Users/Aleksandr/Documents/ParcingFactbook/Countries/";
        File coutryDir = new File(source);
        File[] files = coutryDir.listFiles();

        String forbidenText = "country comparison to the world";

        for (File file : files) {

            File input = new File(source + file.getName());
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements classes = doc.select("[class]");

            File output = new File("C:/Users/Aleksandr/Documents/ParcingFactbook/output/newCountryFile.txt");
            FileWriter out = new FileWriter(output);

            Element previous = null;

            String countryName = "";
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

            File completeFile = new File("C:/Users/Aleksandr/Documents/ParcingFactbook/output/newCountryFile.txt");
            File newFile = new File("C:/Users/Aleksandr/Documents/ParcingFactbook/output/" + countryName + ".txt");
            completeFile.renameTo(newFile);

            //rename operation here
        }

        System.out.println("Parcing Complete!");
    }
}
