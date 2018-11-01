package DatabaseCreator.tables;

import DatabaseCreator.beans.Border;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;


public class BorderManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() {

        String sql = "SELECT id, countryCode, borderCountry, borderLengthKM FROM Border";


        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            String result = null;
            while (rs.next()) {
                result = (rs.getInt("id") + ": "
                        + rs.getString("countryCode") +", "
                        + rs.getString("borderCountry")  +", "
                        + NumberFormat.getNumberInstance(Locale.getDefault())
                        .format(rs.getDouble("borderLengthKM")));

                System.out.println(result);
            }
        } catch (SQLException e){
            DBUtil.processException(e);
        }
    }

    public static boolean insert(Border bean) {

        String sql = "INSERT INTO Border (countryCode, borderCountry, borderLengthKM) " +
                "VALUES (?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setString(2, bean.getBorderCountry());
            stmt.setDouble(3, bean.getBorderLength());

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
