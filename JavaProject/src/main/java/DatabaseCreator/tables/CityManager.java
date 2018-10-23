package DatabaseCreator.tables;

import DatabaseCreator.beans.City;
import DatabaseCreator.beans.CountryMain;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;


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
                        + NumberFormat.getNumberInstance(Locale.getDefault())
                        .format(rs.getInt("population")));

                System.out.println(result);
            }
        } catch (SQLException e){
            DBUtil.processException(e);
        }
    }

    public static boolean insert(City bean) {

        String sql = "INSERT into City (countryCode, cityName, population, capital) " +
                "VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setString(2, bean.getCityName());
            stmt.setInt(3, bean.getPopulation());
            stmt.setBoolean(4, bean.getCapital());

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
