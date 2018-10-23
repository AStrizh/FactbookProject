package DatabaseCreator.tables;

import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CityManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() {

        String sql = "SELECT id, countryCode, cityName, population FROM City";


        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            String result = null;
            while (rs.next()) {
                result = (rs.getInt("id") + ": "
                        + rs.getString("countryCode") +", "
                        + rs.getString("cityName")  +", "
                        + rs.getString("population"));

                System.out.println(result);
            }
        } catch (SQLException e){
            DBUtil.processException(e);
        }
    }
}
