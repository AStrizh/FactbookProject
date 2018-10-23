package DatabaseCreator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error Code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }
}
