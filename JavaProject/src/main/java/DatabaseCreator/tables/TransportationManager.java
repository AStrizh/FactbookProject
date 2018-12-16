package DatabaseCreator.tables;

import DatabaseCreator.beans.Transportation;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
public class TransportationManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();


    public static boolean insert(Transportation bean) {

        String sql = "INSERT INTO Transportation " +
                "(countryCode, registeredAirCarriers, airCarriersAircraft, airCarrierPassengers, airCarrierFreight, " +
                "civilAircraftCode, totalAirports, pavedRunways, pavedOver3047m, pavedBetween2438TO3047m, " +
                "pavedBetween1524TO2437m, pavedBetween914TO1523m, pavedUnder914m, unpavedRunways, unpavedOver3047m, " +
                "unpavedBetween2438TO3047m, unpavedBetween1524TO2437m, unpavedBetween914TO1523m, unpavedUnder914m, heliports, " +
                "pipelines, totalRailwayKM, broadGaugeKM, standardGaugeKM, narrowGaugeKM, " +
                "dualGaugeKM, totalRoadwaysKM, pavedRoadwaysKM, unpavedRoadwaysKM, waterwaysKM, " +
                "merchantMarine, merchantMarineType, foreignOwned, registeredInternationally, majorSeaport, " +
                "riverPort, oilTerminal, dryCargoPort, containerPort, lNGTerminal, cruisePort) " +

                "VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, ?)";


        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setInt(2, bean.getRegisteredAirCarriers());
            stmt.setInt(3, bean.getAirCarriersAircraft());
            stmt.setInt(4, bean.getAirCarrierPassengers());
            stmt.setLong(5, bean.getAirCarrierFreight());
            stmt.setString(6, bean.getCivilAircraftCode());
            stmt.setInt(7, bean.getTotalAirports());
            stmt.setInt(8, bean.getPavedRunways());
            stmt.setInt(9, bean.getPavedOver3047m());
            stmt.setInt(10, bean.getPavedBetween2438TO3047m());
            stmt.setInt(11, bean.getPavedBetween1524TO2437m());
            stmt.setInt(12, bean.getPavedBetween914TO1523m());
            stmt.setInt(13, bean.getPavedUnder914m());
            stmt.setInt(14, bean.getUnpavedRunways());
            stmt.setInt(15, bean.getUnpavedOver3047m());
            stmt.setInt(16, bean.getUnpavedBetween2438TO3047m());
            stmt.setInt(17, bean.getUnpavedBetween1524TO2437m());
            stmt.setInt(18, bean.getUnpavedBetween914TO1523m());
            stmt.setInt(19, bean.getUnpavedUnder914m());
            stmt.setInt(20, bean.getHeliports());
            stmt.setString(21, bean.getPipelines());
            stmt.setInt(22, bean.getTotalRailwayKM());
            stmt.setInt(23, bean.getBroadGaugeKM());
            stmt.setInt(24, bean.getStandardGaugeKM());
            stmt.setInt(25, bean.getNarrowGaugeKM());
            stmt.setInt(26, bean.getDualGaugeKM());
            stmt.setInt(27, bean.getTotalRoadwaysKM());
            stmt.setInt(28, bean.getPavedRoadwaysKM());
            stmt.setInt(29, bean.getUnpavedRoadwaysKM());
            stmt.setInt(30, bean.getWaterwaysKM());
            stmt.setInt(31, bean.getMerchantMarine());
            stmt.setString(32, bean.getMerchantMarineType());
            stmt.setString(33, bean.getForeignOwned());
            stmt.setString(34, bean.getRegisteredInternationally());
            stmt.setString(35, bean.getMajorSeaport());
            stmt.setString(36, bean.getRiverPort());
            stmt.setString(37, bean.getOilTerminal());
            stmt.setString(38, bean.getDryCargoPort());
            stmt.setString(39, bean.getContainerPort());
            stmt.setString(40, bean.getLNGTerminal());
            stmt.setString(41, bean.getCruisePort());

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
