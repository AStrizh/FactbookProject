package DatabaseCreator.tables;

import DatabaseCreator.util.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryMainManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static String displayAllRows() throws SQLException {

        String sql = "SELECT id, countryCode, countryName, region, introduction FROM CountryMain";
        StringBuilder bf = new StringBuilder();
        String result = null;

        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            while (rs.next()) {
                result = (rs.getInt("id") + ": "
                         + rs.getString("countryCode") +", "
                         + rs.getString("countryName")  +", "
                         + rs.getString("region")  +", "
                         + rs.getString("introduction"));
            }
        }
        return bf.toString();
    }
}
