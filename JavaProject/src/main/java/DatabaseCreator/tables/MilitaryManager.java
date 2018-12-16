package DatabaseCreator.tables;

import DatabaseCreator.beans.Military;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
public class MilitaryManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static boolean insert(Military bean) {

        String sql = "INSERT INTO Military " +
                "(countryCode, militaryExpenditure, militaryObligation, militaryBranches) " +

                "VALUES (?, ?, ?, ?)";


        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setDouble(2, bean.getMilitaryExpenditure());
            stmt.setString(3, bean.getMilitaryObligation());
            stmt.setString(4, bean.getMilitaryBranches());

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
