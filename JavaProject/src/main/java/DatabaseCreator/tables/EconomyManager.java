package DatabaseCreator.tables;

import DatabaseCreator.beans.Economy;
import DatabaseCreator.util.ConnectionManager;
import DatabaseCreator.util.DBUtil;

import java.sql.*;

public class EconomyManager {

    private static Connection conn = ConnectionManager.getInstance().getConnection();

    public static boolean insert(Economy bean) {

        String sql = "INSERT INTO Economy " +
                "(countryCode, overview, gDPPurchasingPowerParity, gDPOfficialExchangeRate, gDPRealGrowthRate, " +
                "gDPPerCapita, grossNationalSaving, householdConsumption, governmentConsumption, investmentFixedCapital, " +
                "investmentInventories, exports, imports, gDPAgriculture, gDPIndustry, " +
                "gDPServices, agricultureProducts, industries, industrialGrowth, laborForce, " +
                "occupationAgriculture, occupationIndustry, occupationServices, unemploymentRate, belowPovertyLine, " +
                "lowest10PCTConsumption, highest10PCTConsumption, giniIndexIncome, revenues, expenditures, " +
                "taxes, budgetSurplus, publicDebt, fiscalYear, inflation, " +
                "centralBankDiscount, commercialBankLending, narrowMoney, broadMoney, domesticCredit, " +
                "valueTradedShares, currentAccountBalance, exportsTotal, exportsCommodities, exportsPartners, " +
                "importsTotal, importsCommodities, importsPartners, foreignGoldReserves, debtExternal, " +
                "foreignInvestmentHome, foreignInvestmentAbroad, currencyText, exchangeRate) " +

                "VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, "+ "?, ?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getCountryCode());
            stmt.setString(2, bean.getOverview());
            stmt.setDouble(3, bean.getGDPPurchasingPowerParity());
            stmt.setDouble(4, bean.getGDPOfficialExchangeRate());
            stmt.setDouble(5, bean.getGDPRealGrowthRate());
            stmt.setInt(6, bean.getGDPPerCapita());
            stmt.setDouble(7, bean.getGrossNationalSaving());
            stmt.setDouble(8, bean.getHouseholdConsumption());
            stmt.setDouble(9, bean.getGovernmentConsumption());
            stmt.setDouble(10, bean.getInvestmentFixedCapital());
            stmt.setDouble(11, bean.getInvestmentInventories());
            stmt.setDouble(12, bean.getExports());
            stmt.setDouble(13, bean.getImports());
            stmt.setDouble(14, bean.getGDPAgriculture());
            stmt.setDouble(15, bean.getGDPIndustry());
            stmt.setDouble(16, bean.getGDPServices());
            stmt.setString(17, bean.getAgricultureProducts());
            stmt.setString(18, bean.getIndustries());
            stmt.setDouble(19, bean.getIndustrialGrowth());
            stmt.setInt(20, bean.getLaborForce());
            stmt.setDouble(21, bean.getOccupationAgriculture());
            stmt.setDouble(22, bean.getOccupationIndustry());
            stmt.setDouble(23, bean.getOccupationServices());
            stmt.setDouble(24, bean.getUnemploymentRate());
            stmt.setDouble(25, bean.getBelowPovertyLine());
            stmt.setDouble(26, bean.getLowest10PCTConsumption());
            stmt.setDouble(27, bean.getHighest10PCTConsumption());
            stmt.setDouble(28, bean.getGiniIndexIncome());
            stmt.setDouble(29, bean.getRevenues());
            stmt.setDouble(30, bean.getExpenditures());
            stmt.setDouble(31, bean.getTaxes());
            stmt.setDouble(32, bean.getBudgetSurplus());
            stmt.setDouble(33, bean.getPublicDebt());
            stmt.setString(34, bean.getFiscalYear());
            stmt.setDouble(35, bean.getInflation());
            stmt.setDouble(36, bean.getCentralBankDiscount());
            stmt.setDouble(37, bean.getCommercialBankLending());
            stmt.setDouble(38, bean.getNarrowMoney());
            stmt.setDouble(39, bean.getBroadMoney());
            stmt.setDouble(40, bean.getDomesticCredit());
            stmt.setDouble(41, bean.getValueTradedShares());
            stmt.setDouble(42, bean.getCurrentAccountBalance());
            stmt.setDouble(43, bean.getExportsTotal());
            stmt.setString(44, bean.getExportsCommodities());
            stmt.setString(45, bean.getExportsPartners());
            stmt.setDouble(46, bean.getImportsTotal());
            stmt.setString(47, bean.getImportsCommodities());
            stmt.setString(48, bean.getImportsPartners());
            stmt.setDouble(49, bean.getForeignGoldReserves());
            stmt.setDouble(50, bean.getDebtExternal());
            stmt.setDouble(51, bean.getForeignInvestmentHome());
            stmt.setDouble(52, bean.getForeignInvestmentAbroad());
            stmt.setString(53, bean.getCurrencyText());
            stmt.setDouble(54, bean.getExchangeRate());


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
