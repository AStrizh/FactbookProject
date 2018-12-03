package DatabaseCreator.tables;

import DatabaseCreator.beans.Economy;
import DatabaseCreator.beans.Government;
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
                "foreignInvestmentHome, foreignInvestmentAbroad, currencyString, exchangeRate) " +

                "VALUES (?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " + "?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, "+ "?, ?, ?, ?)";

        try (
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {



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
