package DatabaseCreator.tables;

import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryMainManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() {

        String sql = "SELECT id, countryCode, countryName, region, introduction FROM CountryMain";


        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            String result = null;
            while (rs.next()) {
                result = (rs.getInt("id") + ": "
                         + rs.getString("countryCode") +", "
                         + rs.getString("countryName")  +", "
                         + rs.getString("region")  +", "
                         + rs.getString("introduction"));

                System.out.println(result);
            }
        } catch (SQLException e){
            DBUtil.processException(e);
        }
    }
}