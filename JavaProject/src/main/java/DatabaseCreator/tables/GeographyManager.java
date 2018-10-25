package DatabaseCreator.tables;

import DatabaseCreator.beans.Geography;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;

public class GeographyManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static void displayAllRows() {

        String sql = "SELECT * FROM CountryMain";

        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            String result = null;
            while (rs.next()) {
                result = (rs.getInt("id") + ": "
                        + rs.getString("countryCode") +", "
                        + rs.getDouble("lat") +", "
                        + rs.getDouble("lng") +", "
                        + rs.getInt("landArea") + ", "
                        + rs.getInt("waterArea") + ", "
                        + rs.getInt("landBoundaries") + ", "
                        + rs.getInt("coastline") + ", "
                        + rs.getInt("meanElevation") + ", "
                        + rs.getInt("lowestPointDistance") + ", "
                        + rs.getString("lowestPointName") +", "
                        + rs.getInt("highestPointDistance") + ", "
                        + rs.getString("highestPointName") +", "
                        + rs.getInt("irrigatedLand"));

                System.out.println(result);
            }
        } catch (SQLException e){
            DBUtil.processException(e);
        }
    }

    public static boolean insert(Geography bean) {

        String sql = "INSERT INTO CountryMain " +
                "(countryCode, lat, lng, landArea, waterArea, " +
                "landBoundaries, coastline, meanElevation, lowestPointDistance, lowestPointName, " +
                "highestPointDistance, highestPointName,irrigatedLand) " +
                "VALUES (?, ?, ?, ?, ? " +"?, ?, ?, ?, ?, ? "+ "?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setDouble(2, bean.getLat());
            stmt.setDouble(3, bean.getLng());
            stmt.setInt(4, bean.getLandArea());
            stmt.setInt(5, bean.getWaterArea());

            stmt.setInt(5, bean.getLandBoundaries());
            stmt.setInt(5, bean.getCoastline());
            stmt.setInt(5, bean.getMeanElevation());
            stmt.setInt(5, bean.getLowestPointDistance());
            stmt.setString(5, bean.getLowestPointName());

            stmt.setInt(5, bean.getHighestPointDistance());
            stmt.setString(5, bean.getHighestPointName());
            stmt.setInt(5, bean.getIrrigatedLand());

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
