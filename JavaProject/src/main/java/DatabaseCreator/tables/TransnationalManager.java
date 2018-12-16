package DatabaseCreator.tables;

import DatabaseCreator.beans.Transnational;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
public class TransnationalManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();


    public static boolean insert(Transnational bean) {

        String sql = "INSERT INTO Transnational " +
                "(countryCode, disputes, refugees, iDPs, statelessPersons, " +
                "traffickingSituation, traffickingTierRating, illicitDrugs) " +

                "VALUES (?, ?, ?, ?, ?, " +  "?, ?, ?)";


        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setString(2, bean.getDisputes());
            stmt.setString(3, bean.getRefugees());
            stmt.setString(4, bean.getIDPs());
            stmt.setString(5, bean.getStatelessPersons());
            stmt.setString(6, bean.getTraffickingSituation());
            stmt.setString(7, bean.getTraffickingTierRating());
            stmt.setString(8, bean.getIllicitDrugs());

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
