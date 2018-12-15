package DatabaseCreator.tables;

import DatabaseCreator.beans.Communications;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
public class CommunicationsManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static boolean insert(Communications bean) {

        String sql = "INSERT INTO Communications " +
                "(countryCode, totalFixedLines, fixedLinesPer100, totalCellular, cellularPer100, " +
                "telephoneGeneralAssessment, telephoneSystemDomestic, telephoneSystemInternational, broadcastMedia, internetCode, " +
                "internetUsers, internetUsersPCT) " +

                "VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?)";


        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setInt(2, bean.getTotalFixedLines());
            stmt.setInt(3, bean.getFixedLinesPer100());
            stmt.setInt(4, bean.getTotalCellular());
            stmt.setInt(5, bean.getCellularPer100());
            stmt.setString(6, bean.getTelephoneGeneralAssessment());
            stmt.setString(7, bean.getTelephoneSystemDomestic());
            stmt.setString(8, bean.getTelephoneSystemInternational());
            stmt.setString(9, bean.getBroadcastMedia());
            stmt.setString(10, bean.getInternetCode());
            stmt.setInt(11, bean.getInternetUsers());
            stmt.setDouble(12, bean.getInternetUsersPCT());


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
