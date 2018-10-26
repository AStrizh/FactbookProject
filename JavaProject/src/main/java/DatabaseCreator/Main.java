package DatabaseCreator;

import java.io.*;
import java.io.IOException;

import DatabaseCreator.parsers.ParserMain;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DatabaseRestarter;

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
        //refreshes the database
        new DatabaseRestarter();


        //Source project folder where country files are stored
        //Change to your own directory
        String projectFolder = "C:/Users/Aleksandr/Documents/ParcingFactbook/";
        String source = projectFolder + "Countries/";
        File countryDir = new File(source);
        File[] files = countryDir.listFiles();

        //Loops through all the files in the folder
        for (File file : files)
            ParserMain.mainParser(file);

        System.out.println("Parsing Complete!");
        ConnectionManager.getInstance().close();
    }
}
