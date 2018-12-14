package DatabaseCreator.tables;


import DatabaseCreator.beans.Energy;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;
public class EnergyManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static boolean insert(Energy bean) {

        String sql = "INSERT INTO Energy " +
                "(countryCode, withoutElectricity, electrificationPopulationPCT, electrificationUrbanPCT, electrificationRuralPCT, " +
                "electricityProductionMillionskWh, electricityConsumptionMillionskWh, electricityExportsMillionskWh, electricityImportsMillionskWh, electricityCapacityThousandskW, " +
                "electricityFossilFuelsPCT, electricityNuclearFuelsPCT, electricityHydroelectricPlantsPCT, electricityOtherRenewableSourcesPCT, oilProductionBarrelsPerDay, " +
                "oilExportsBarrelsPerDay, oilImportsBarrelsPerDay, oilProvedReservesThousandBarrels, refinedPetroleumProductionBarrelsPerDay, refinedPetroleumConsumptionBarrelsPerDay, " +
                "refinedPetroleumExportsBarrelsPerDay, refinedPetroleumImportsBarrelsPerDay, naturalGasProductionMillionCubicMeters, naturalGasConsumptionMillionCubicMeters,  naturalGasExportsMillionCubicMeters, " +
                "naturalGasImportsMillionCubicMeters, naturalGasProvedReservesMillionCubicMeters, carbonDioxideEmissionsMillionMetricTons) " +

                "VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?)";


        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setDouble(2, bean.getWithoutElectricity());
            stmt.setDouble(3, bean.getElectrificationPopulationPCT());
            stmt.setDouble(4, bean.getElectrificationUrbanPCT());
            stmt.setDouble(5, bean.getElectrificationRuralPCT());

            stmt.setInt(6, bean.getElectricityProductionMillionskWh());
            stmt.setInt(7, bean.getElectricityConsumptionMillionskWh());
            stmt.setInt(8, bean.getElectricityExportsMillionskWh());
            stmt.setInt(9, bean.getElectricityImportsMillionskWh());
            stmt.setInt(10, bean.getElectricityCapacityThousandskW());
            stmt.setDouble(11, bean.getElectricityFossilFuelsPCT());
            stmt.setDouble(12, bean.getElectricityNuclearFuelsPCT());
            stmt.setDouble(13, bean.getElectricityHydroelectricPlantsPCT());
            stmt.setDouble(14, bean.getElectricityOtherRenewableSourcesPCT());

            stmt.setInt(15, bean.getOilProductionBarrelsPerDay());
            stmt.setInt(16, bean.getOilExportsBarrelsPerDay());
            stmt.setInt(17, bean.getOilImportsBarrelsPerDay());
            stmt.setInt(18, bean.getOilProvedReservesThousandBarrels());
            stmt.setInt(19, bean.getRefinedPetroleumProductionBarrelsPerDay());
            stmt.setInt(20, bean.getRefinedPetroleumConsumptionBarrelsPerDay());
            stmt.setInt(21, bean.getRefinedPetroleumExportsBarrelsPerDay());
            stmt.setInt(22, bean.getRefinedPetroleumImportsBarrelsPerDay());
            stmt.setInt(23, bean.getNaturalGasProductionMillionCubicMeters());
            stmt.setInt(24, bean.getNaturalGasConsumptionMillionCubicMeters());
            stmt.setInt(25, bean.getNaturalGasExportsMillionCubicMeters());
            stmt.setInt(26, bean.getNaturalGasImportsMillionCubicMeters());
            stmt.setInt(27, bean.getNaturalGasProvedReservesMillionCubicMeters());
            stmt.setInt(28, bean.getCarbonDioxideEmissionsMillionMetricTons());


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
