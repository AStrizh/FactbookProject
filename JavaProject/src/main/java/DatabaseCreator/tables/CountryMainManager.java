package DatabaseCreator.tables;

import DatabaseCreator.beans.CountryMain;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;

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

    public static boolean insert(CountryMain bean) {

        String sql = "INSERT into CountryMain (countryCode, countryName, region, introduction) " +
                "VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setString(2, bean.getCountryName());
            stmt.setString(3, bean.getRegion());
            stmt.setString(4, bean.getIntroduction());

            if (stmt.executeUpdate() != 1) {
                System.err.println("No rows affected");
                return false;
            } else
                return true;


        } catch (SQLException e) {
            DBUtil.processException(e);
            return false;
        }
    }
}
