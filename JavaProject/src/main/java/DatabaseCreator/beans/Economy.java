package DatabaseCreator.beans;

import java.io.Serializable;

public class Economy implements Serializable {

    private static final long serialVersionUID = -6893834714693397185L;
    private int id;
    private String countryCode;
    private String overview;
    private double gDPPurchasingPowerParity;
    private double gDPOfficialExchangeRate;
    private double gDPRealGrowthRate;
    private int gDPPerCapita;
    private double grossNationalSaving;
    private double householdConsumption;
    private double governmentConsumption;
    private double investmentFixedCapital;
    private double investmentInventories;
    private double exports;
    private double imports;
    private double gDPAgriculture;
    private double gDPIndustry;
    private double gDPServices;
    private String agricultureProducts;
    private String industries;
    private double industrialGrowth;
    private int laborForce;
    private double occupationAgriculture;
    private double occupationIndustry;
    private double occupationServices;
    private double unemploymentRate;
    private double belowPovertyLine;
    private double lowest10PCTConsumption;
    private double highest10PCTConsumption;
    private double giniIndexIncome;
    private double revenues;
    private double expenditures;
    private double taxes;
    private double budgetSurplus;
    private double publicDebt;
    private String fiscalYear;
    private double inflation;
    private double centralBankDiscount;
    private double commercialBankLending;
    private double narrowMoney;
    private double broadMoney;
    private double domesticCredit;
    private double valueTradedShares;
    private double currentAccountBalance;
    private double exportsTotal;
    private double exportsCommodities;
    private String exportsPartners;
    private double importsTotal;
    private String importsCommodities;
    private double importsPartners;
    private double foreignGoldReserves;
    private double debtExternal;
    private double foreignInvestmentHome;
    private double foreignInvestmentAbroad;
    private String currencyString;
    private double exchangeRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getgDPPurchasingPowerParity() {
        return gDPPurchasingPowerParity;
    }

    public void setgDPPurchasingPowerParity(double gDPPurchasingPowerParity) {
        this.gDPPurchasingPowerParity = gDPPurchasingPowerParity;
    }

    public double getgDPOfficialExchangeRate() {
        return gDPOfficialExchangeRate;
    }

    public void setgDPOfficialExchangeRate(double gDPOfficialExchangeRate) {
        this.gDPOfficialExchangeRate = gDPOfficialExchangeRate;
    }

    public double getgDPRealGrowthRate() {
        return gDPRealGrowthRate;
    }

    public void setgDPRealGrowthRate(double gDPRealGrowthRate) {
        this.gDPRealGrowthRate = gDPRealGrowthRate;
    }

    public int getgDPPerCapita() {
        return gDPPerCapita;
    }

    public void setgDPPerCapita(int gDPPerCapita) {
        this.gDPPerCapita = gDPPerCapita;
    }

    public double getGrossNationalSaving() {
        return grossNationalSaving;
    }

    public void setGrossNationalSaving(double grossNationalSaving) {
        this.grossNationalSaving = grossNationalSaving;
    }

    public double getHouseholdConsumption() {
        return householdConsumption;
    }

    public void setHouseholdConsumption(double householdConsumption) {
        this.householdConsumption = householdConsumption;
    }

    public double getGovernmentConsumption() {
        return governmentConsumption;
    }

    public void setGovernmentConsumption(double governmentConsumption) {
        this.governmentConsumption = governmentConsumption;
    }

    public double getInvestmentFixedCapital() {
        return investmentFixedCapital;
    }

    public void setInvestmentFixedCapital(double investmentFixedCapital) {
        this.investmentFixedCapital = investmentFixedCapital;
    }

    public double getInvestmentInventories() {
        return investmentInventories;
    }

    public void setInvestmentInventories(double investmentInventories) {
        this.investmentInventories = investmentInventories;
    }

    public double getExports() {
        return exports;
    }

    public void setExports(double exports) {
        this.exports = exports;
    }

    public double getImports() {
        return imports;
    }

    public void setImports(double imports) {
        this.imports = imports;
    }

    public double getgDPAgriculture() {
        return gDPAgriculture;
    }

    public void setgDPAgriculture(double gDPAgriculture) {
        this.gDPAgriculture = gDPAgriculture;
    }

    public double getgDPIndustry() {
        return gDPIndustry;
    }

    public void setgDPIndustry(double gDPIndustry) {
        this.gDPIndustry = gDPIndustry;
    }

    public double getgDPServices() {
        return gDPServices;
    }

    public void setgDPServices(double gDPServices) {
        this.gDPServices = gDPServices;
    }

    public String getAgricultureProducts() {
        return agricultureProducts;
    }

    public void setAgricultureProducts(String agricultureProducts) {
        this.agricultureProducts = agricultureProducts;
    }

    public String getIndustries() {
        return industries;
    }

    public void setIndustries(String industries) {
        this.industries = industries;
    }

    public double getIndustrialGrowth() {
        return industrialGrowth;
    }

    public void setIndustrialGrowth(double industrialGrowth) {
        this.industrialGrowth = industrialGrowth;
    }

    public int getLaborForce() {
        return laborForce;
    }

    public void setLaborForce(int laborForce) {
        this.laborForce = laborForce;
    }

    public double getOccupationAgriculture() {
        return occupationAgriculture;
    }

    public void setOccupationAgriculture(double occupationAgriculture) {
        this.occupationAgriculture = occupationAgriculture;
    }

    public double getOccupationIndustry() {
        return occupationIndustry;
    }

    public void setOccupationIndustry(double occupationIndustry) {
        this.occupationIndustry = occupationIndustry;
    }

    public double getOccupationServices() {
        return occupationServices;
    }

    public void setOccupationServices(double occupationServices) {
        this.occupationServices = occupationServices;
    }

    public double getUnemploymentRate() {
        return unemploymentRate;
    }

    public void setUnemploymentRate(double unemploymentRate) {
        this.unemploymentRate = unemploymentRate;
    }

    public double getBelowPovertyLine() {
        return belowPovertyLine;
    }

    public void setBelowPovertyLine(double belowPovertyLine) {
        this.belowPovertyLine = belowPovertyLine;
    }

    public double getLowest10PCTConsumption() {
        return lowest10PCTConsumption;
    }

    public void setLowest10PCTConsumption(double lowest10PCTConsumption) {
        this.lowest10PCTConsumption = lowest10PCTConsumption;
    }

    public double getHighest10PCTConsumption() {
        return highest10PCTConsumption;
    }

    public void setHighest10PCTConsumption(double highest10PCTConsumption) {
        this.highest10PCTConsumption = highest10PCTConsumption;
    }

    public double getGiniIndexIncome() {
        return giniIndexIncome;
    }

    public void setGiniIndexIncome(double giniIndexIncome) {
        this.giniIndexIncome = giniIndexIncome;
    }

    public double getRevenues() {
        return revenues;
    }

    public void setRevenues(double revenues) {
        this.revenues = revenues;
    }

    public double getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(double expenditures) {
        this.expenditures = expenditures;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getBudgetSurplus() {
        return budgetSurplus;
    }

    public void setBudgetSurplus(double budgetSurplus) {
        this.budgetSurplus = budgetSurplus;
    }

    public double getPublicDebt() {
        return publicDebt;
    }

    public void setPublicDebt(double publicDebt) {
        this.publicDebt = publicDebt;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public double getInflation() {
        return inflation;
    }

    public void setInflation(double inflation) {
        this.inflation = inflation;
    }

    public double getCentralBankDiscount() {
        return centralBankDiscount;
    }

    public void setCentralBankDiscount(double centralBankDiscount) {
        this.centralBankDiscount = centralBankDiscount;
    }

    public double getCommercialBankLending() {
        return commercialBankLending;
    }

    public void setCommercialBankLending(double commercialBankLending) {
        this.commercialBankLending = commercialBankLending;
    }

    public double getNarrowMoney() {
        return narrowMoney;
    }

    public void setNarrowMoney(double narrowMoney) {
        this.narrowMoney = narrowMoney;
    }

    public double getBroadMoney() {
        return broadMoney;
    }

    public void setBroadMoney(double broadMoney) {
        this.broadMoney = broadMoney;
    }

    public double getDomesticCredit() {
        return domesticCredit;
    }

    public void setDomesticCredit(double domesticCredit) {
        this.domesticCredit = domesticCredit;
    }

    public double getValueTradedShares() {
        return valueTradedShares;
    }

    public void setValueTradedShares(double valueTradedShares) {
        this.valueTradedShares = valueTradedShares;
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

    public double getExportsTotal() {
        return exportsTotal;
    }

    public void setExportsTotal(double exportsTotal) {
        this.exportsTotal = exportsTotal;
    }

    public double getExportsCommodities() {
        return exportsCommodities;
    }

    public void setExportsCommodities(double exportsCommodities) {
        this.exportsCommodities = exportsCommodities;
    }

    public String getExportsPartners() {
        return exportsPartners;
    }

    public void setExportsPartners(String exportsPartners) {
        this.exportsPartners = exportsPartners;
    }

    public double getImportsTotal() {
        return importsTotal;
    }

    public void setImportsTotal(double importsTotal) {
        this.importsTotal = importsTotal;
    }

    public String getImportsCommodities() {
        return importsCommodities;
    }

    public void setImportsCommodities(String importsCommodities) {
        this.importsCommodities = importsCommodities;
    }

    public double getImportsPartners() {
        return importsPartners;
    }

    public void setImportsPartners(double importsPartners) {
        this.importsPartners = importsPartners;
    }

    public double getForeignGoldReserves() {
        return foreignGoldReserves;
    }

    public void setForeignGoldReserves(double foreignGoldReserves) {
        this.foreignGoldReserves = foreignGoldReserves;
    }

    public double getDebtExternal() {
        return debtExternal;
    }

    public void setDebtExternal(double debtExternal) {
        this.debtExternal = debtExternal;
    }

    public double getForeignInvestmentHome() {
        return foreignInvestmentHome;
    }

    public void setForeignInvestmentHome(double foreignInvestmentHome) {
        this.foreignInvestmentHome = foreignInvestmentHome;
    }

    public double getForeignInvestmentAbroad() {
        return foreignInvestmentAbroad;
    }

    public void setForeignInvestmentAbroad(double foreignInvestmentAbroad) {
        this.foreignInvestmentAbroad = foreignInvestmentAbroad;
    }

    public String getCurrencyString() {
        return currencyString;
    }

    public void setCurrencyString(String currencyString) {
        this.currencyString = currencyString;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
