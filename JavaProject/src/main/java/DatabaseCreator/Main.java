package DatabaseCreator;

import java.io.*;
import java.io.IOException;

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

        CountryMainManager.displayAllRows();

        ConnectionManager.getInstance().close();
    }


}
