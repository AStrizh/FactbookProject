package DatabaseCreator.tables;

import DatabaseCreator.beans.Society;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;

public class SocietyManager {


    private static Connection conn = ConnectionManager.getInstance().getConnection();

    //TODO: Make the display rows method
//    public static void displayAllRows() {
//
//        String sql = "SELECT * FROM Society";
//
//        try (
//                Statement stmt = conn.createStatement();
//                ResultSet rs = stmt.executeQuery(sql);
//        ){
//            String result = null;
//            while (rs.next()) {
//                result = (rs.getInt("id") + ": "
//                        + rs.getString("countryCode") +", "
//                        + rs.getDouble("lat") +", "
//                        + rs.getDouble("lng") +", "
//                        + rs.getDouble("landArea") + ", "
//                        + rs.getDouble("waterArea") + ", "
//                        + rs.getDouble("landBoundaries") + ", "
//                        + rs.getDouble("coastline") + ", "
//                        + rs.getDouble("meanElevation") + ", "
//                        + rs.getDouble("lowestPointDistance") + ", "
//                        + rs.getString("lowestPointName") +", "
//                        + rs.getDouble("highestPointDistance") + ", "
//                        + rs.getString("highestPointName") +", "
//                        + rs.getDouble("irrigatedLand"));
//
//                System.out.println(result);
//            }
//        } catch (SQLException e){
//            DBUtil.processException(e);
//        }
//    }

    public static boolean insert(Society bean) {


        String sql = "INSERT INTO Society " +
                "(countryCode, population, Male0_14, Female0_14, Male15_24, " +
                "Female15_24, Male25_54, Female25_54, Male55_64, Female55_64, " +
                "Male65, Female65,youthDependencyRatio,elderlyDependencyRatio,potentialSupportRatio, " +
                "medianAgeMale, medianAgeFemale, populationGrowthRate, birthRatePer1K, deathRatePer1K, " +
                "netMigrationRate, urbanPopulation, urbanizationRate, motherMeanAgeAtFirstBirth, maternalMortalityRatePer100K, " +
                "infantMaleMortalityRatePer1K, infantFemaleMortalityRatePer1K, maleLifeExpectancy, femaleLifeExpectancy, childrenBornPerWoman, " +
                "contraceptivePrevalencePCT, healthExpenditurePCT, physiciansPer1K, hospitalBedPer1K, improvedUrbanDrinkingWaterPCT, " +
                "improvedRuralDrinkingWaterPCT, improvedUrbanSanitationFacilityAccessPCT, improvedRuralSanitationFacilityAccessPCT, improvedTotalSanitationFacilityAccessPCT, hIVAIDSPrevalencePCT, " +
                "hIVAIDSAfflicted, hIVAIDSDeaths, infectiousDiseasesRisk, adultObesityPCT, educationExpenditures, " +
                "maleLiteracy, femaleLiteracy, MaleSchoolLifeExpectancy, FemaleSchoolLifeExpectancy, MaleUnemployment, FemaleUnemployment) " +

                "VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?)";


        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setInt(2, bean.getPopulation());
            stmt.setInt(3, bean.getMale0_14());
            stmt.setInt(4, bean.getFemale0_14());
            stmt.setInt(5, bean.getMale15_24());
            stmt.setInt(6, bean.getFemale15_24());
            stmt.setInt(7, bean.getMale25_54());
            stmt.setInt(8, bean.getFemale25_54());
            stmt.setInt(9, bean.getMale55_64());
            stmt.setInt(10, bean.getFemale55_64());

            stmt.setInt(11, bean.getMale65());
            stmt.setInt(12, bean.getFemale65());
            stmt.setDouble(13, bean.getYouthDependencyRatio());
            stmt.setDouble(14, bean.getElderlyDependencyRatio());
            stmt.setDouble(15, bean.getPotentialSupportRatio());
            stmt.setDouble(16, bean.getMedianAgeMale());
            stmt.setDouble(17, bean.getMedianAgeFemale());
            stmt.setDouble(18, bean.getPopulationGrowthRate());
            stmt.setDouble(19, bean.getBirthRatePer1K());

            stmt.setDouble(20, bean.getDeathRatePer1K());
            stmt.setDouble(21, bean.getNetMigrationRate());
            stmt.setInt(22, bean.getUrbanPopulation());
            stmt.setDouble(23, bean.getUrbanizationRate());
            stmt.setDouble(24, bean.getMotherMeanAgeAtFirstBirth());
            stmt.setInt(25, bean.getMaternalMortalityRatePer100K());
            stmt.setDouble(26, bean.getInfantMaleMortalityRatePer1K());
            stmt.setDouble(27, bean.getInfantFemaleMortalityRatePer1K());
            stmt.setDouble(28, bean.getMaleLifeExpectancy());
            stmt.setDouble(29, bean.getFemaleLifeExpectancy());

            stmt.setDouble(30, bean.getChildrenBornPerWoman());
            stmt.setDouble(31, bean.getContraceptivePrevalencePCT());
            stmt.setDouble(32, bean.getHealthExpenditurePCT());
            stmt.setDouble(33, bean.getPhysiciansPer1K());
            stmt.setDouble(34, bean.getHospitalBedPer1K());
            stmt.setDouble(35, bean.getImprovedUrbanDrinkingWaterPCT());
            stmt.setDouble(36, bean.getImprovedRuralDrinkingWaterPCT());
            stmt.setDouble(37, bean.getImprovedUrbanSanitationFacilityAccessPCT());
            stmt.setDouble(38, bean.getImprovedRuralSanitationFacilityAccessPCT());
            stmt.setDouble(39, bean.getImprovedTotalSanitationFacilityAccessPCT());

            stmt.setDouble(40, bean.gethIVAIDSPrevalencePCT());
            stmt.setInt(41, bean.gethIVAIDSAfflicted());
            stmt.setInt(42, bean.gethIVAIDSDeaths());
            stmt.setString(43, bean.getInfectiousDiseasesRisk());
            stmt.setDouble(44, bean.getAdultObesityPCT());
            stmt.setDouble(45, bean.getEducationExpenditures());
            stmt.setDouble(46, bean.getMaleLiteracy());
            stmt.setDouble(47, bean.getFemaleLiteracy());
            stmt.setInt(48, bean.getMaleSchoolLifeExpectancy());
            stmt.setInt(49, bean.getFemaleSchoolLifeExpectancy());
            stmt.setDouble(50, bean.getMaleUnemployment());
            stmt.setDouble(51, bean.getFemaleUnemployment());


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
