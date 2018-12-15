package DatabaseCreator.parsers;


import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import DatabaseCreator.beans.*;
import DatabaseCreator.tables.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class ParserMain {

    public static void mainParser( File countryFile) throws IOException {

        Document doc = Jsoup.parse(countryFile, "UTF-8");
        Elements classes = doc.select("[class]");

        CountryMain countryBean = new CountryMain();
        Geography geoBean = new Geography();
        Society societyBean = new Society();
        Government governmentBean = new Government();
        Economy economyBean = new Economy();
        Energy energyBean = new Energy();
        Communications communicationsBean = new Communications();

        Element previous = null;
        String countryCode = null;
        String countryName = "";
        String region = "";
        String sectionTitle = "";
        String categoryTitle = "";
        String introduction = "";
        String econOverview = "";

        //Pulls data from relevant html tags
        for( Element el : classes){

            if(el.className().contains("printHeader")){
                String[] parts = el.text().split("::");
                region = parts[0].trim();

                String tempName = parts[1].trim();
                if(parts[1].trim().contains(" "))
                    countryName = spacedCountryName(tempName);
                else if (parts[1].trim().contains("-"))
                    countryName = hyphenedCountryName(tempName);
                else
                    countryName = singleCountryName(tempName);

                //Identifies currently parsing country
                System.out.println("*******"+countryName+"*******");
            }

            if(el.className().contains("question ")){
                sectionTitle = el.attributes().get("sectiontitle");
                if(countryCode == null)
                    countryCode = el.attributes().get("ccode").toUpperCase();
            }

            if(el.className().contains("_light")){
                categoryTitle = el.text();
            }


            if(el.className().equals("category_data")){

                switch(sectionTitle){
                    case "Introduction":
                        introduction = introduction + el.text() + "\n";
                        break;
                    case "Geography":
                        geoBean.setCountryCode(countryCode);

                        if(categoryTitle.equals("Land boundaries:") && previous.text().equals("total:"))
                            geoBean.setLandBoundaries(createDouble(el.text().split(" ")[0]));


                        if(previous.className().contains("category")){
                            if(previous.text().contains("border countries")){

                                String borders = removeParentheses(el.text()).trim();
                                ArrayList<Border> borderNations = processBorders(
                                        borders.split(" km ,| km,| km"), countryCode);

                                for(Border border : borderNations)
                                    BorderManager.insert(border);
                            }
                        }

                        if(el.text().contains("border countries"))
                            System.out.println(previous.text());

                        if( el.text().contains("lowest point:")){
                            String[] response = processElevation(removeParentheses(el.text()));
                            geoBean.setLowestPointName(response[0]);
                            geoBean.setLowestPointDistance(createDouble(response[1]));
                        }

                        if( el.text().contains("highest point:")){
                            String[] response = processElevation(removeParentheses(el.text()));
                            geoBean.setHighestPointName(response[0]);
                            geoBean.setHighestPointDistance(createDouble(response[1]));
                        }

                        switch (previous.text()){
                            case "Geographic coordinates:":
                                String[] coords = parseGeoCords(el.text());
                                geoBean.setLat(createDouble(coords[0]));
                                geoBean.setLng(createDouble(coords[1]));
                                break;
                            case "Coastline:":
                                geoBean.setCoastline(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Irrigated land:":
                                geoBean.setIrrigatedLand(createDouble(el.text().split(" ")[0]));
                                break;
                            case "land:":
                                geoBean.setLandArea(createDouble(el.text().split(" ")[0]));
                                break;
                            case "water:":
                                geoBean.setWaterArea(createDouble(el.text().split(" ")[0]));
                                break;
                            case "mean elevation:":
                                geoBean.setMeanElevation(createDouble(el.text().split(" ")[0]));
                                break;
                            default:
                                ;
                        }
                        break;
                    case "People and Society":
                        societyBean.setCountryCode(countryCode);

                        if(categoryTitle.contains("Major urban areas") && !previous.text().equals("note:")){

                            ArrayList<City> cityBeans = processCities(el.text().split(";"), countryCode);
                            for(City city : cityBeans)
                                CityManager.insert(city);
                        }

                        switch (categoryTitle){
                            case "Infant mortality rate:":
                                if (previous.text().equals("male:"))
                                    societyBean.setInfantMaleMortalityRatePer1K(createDouble(el.text().split(" ")[0]));
                                else if (previous.text().equals("female:"))
                                    societyBean.setInfantFemaleMortalityRatePer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Life expectancy at birth:":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleLifeExpectancy(createDouble(el.text().split(" ")[0]));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleLifeExpectancy(createDouble(el.text().split(" ")[0]));
                                break;
                            case "School life expectancy (primary to tertiary education):":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleSchoolLifeExpectancy(createInt(el.text().split(" ")[0]));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleSchoolLifeExpectancy(createInt(el.text().split(" ")[0]));
                                break;
                            case "Literacy:":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleLiteracy( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleLiteracy( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                break;
                            case "Unemployment, youth ages 15-24:":
                                if (previous.text().equals("male:"))
                                    societyBean.setMaleUnemployment( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                else if (previous.text().equals("female:"))
                                    societyBean.setFemaleUnemployment( createDouble(
                                            el.text().split(" ")[0].replace("%","") ));
                                break;
                        }


                        switch (previous.text()){
                            case "Population:":
                                if(countryName.equals("Zambia"))
                                    societyBean.setPopulation(15972000);
                                else
                                    societyBean.setPopulation(createInt(removeParentheses(el.text())));
                                break;
                            case "0-14 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale0_14(stats[0]);
                                    societyBean.setFemale0_14(stats[1]);
                                }
                                break;
                            case "15-24 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale15_24(stats[0]);
                                    societyBean.setFemale15_24(stats[1]);
                                }
                                break;
                            case "25-54 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale25_54(stats[0]);
                                    societyBean.setFemale25_54(stats[1]);
                                }
                                break;
                            case "55-64 years:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale55_64(stats[0]);
                                    societyBean.setFemale55_64(stats[1]);
                                }
                                break;
                            case "65 years and over:":
                                if(categoryTitle.equals("Age structure:")){
                                    int[] stats = ageStrucProcessing(el.text());
                                    societyBean.setMale65(stats[0]);
                                    societyBean.setFemale65(stats[1]);
                                }
                                break;
                            case "Population growth rate:":
                                societyBean.setPopulationGrowthRate( createDouble(
                                        el.text().split(" ")[0].replace("%","")
                                ));
                                break;
                            case "Education expenditures:":
                                societyBean.setEducationExpenditures( createDouble(
                                        el.text().split(" ")[0].replace("%","")
                                ));
                                break;
                            case "Birth rate:":
                                societyBean.setBirthRatePer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Death rate:":
                                societyBean.setDeathRatePer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Total fertility rate:":
                                societyBean.setChildrenBornPerWoman(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Net migration rate:":
                                societyBean.setNetMigrationRate(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Mother's mean age at first birth:":
                                societyBean.setMotherMeanAgeAtFirstBirth(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Maternal mortality rate:":
                                societyBean.setMaternalMortalityRatePer100K(createInt(el.text().split(" ")[0]));
                                break;
                            case "degree of risk:":
                                societyBean.setInfectiousDiseasesRisk(el.text());
                                break;
                            case "Contraceptive prevalence rate:":
                                societyBean.setContraceptivePrevalencePCT( createDouble(
                                        removeParentheses(el.text().replace("%","")) ) );
                                break;
                            case "Health expenditures:":
                                societyBean.setHealthExpenditurePCT( createDouble(
                                        el.text().split(" ")[0].replace("%","")) );
                                break;
                            case "Physicians density:":
                                societyBean.setPhysiciansPer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            case "Hospital bed density:":
                                societyBean.setHospitalBedPer1K(createDouble(el.text().split(" ")[0]));
                                break;
                            default:
                                ;

                        }
                        break;
                    case "Government":
                        governmentBean.setCountryCode(countryCode);

                        switch (categoryTitle) {
                            case "Diplomatic representation in the US:":
                                if( previous.text().equals("chief of mission:") ){
                                    String representative = el.text().split("[;,]")[0];
                                    if(representative.contains("(vacant)"))
                                        governmentBean.setDiplomatToUS("VACANT");
                                    else
                                        governmentBean.setDiplomatToUS(removeParentheses(representative));
                                }
                                break;

                            case "Diplomatic representation from the US:":
                                if( previous.text().equals("chief of mission:") ){
                                    String representative = el.text().split("[;,]")[0];
                                    if(representative.contains("(vacant)"))
                                        governmentBean.setDiplomatFromUS("VACANT");
                                    else
                                        governmentBean.setDiplomatFromUS(removeParentheses(representative));
                                }
                                break;
                            default:
                                ;
                        }

                        switch (previous.text()) {
                            case "Government type:":
                                governmentBean.setGovernmentType(el.text());
                                break;
                            case "chief of state:":
                                governmentBean.setChiefOfState( removeParentheses(el.text().split("[;,]")[0]) );
                                break;
                            case "head of government:":
                                String head = removeParentheses( el.text().split("; |,")[0] );
                                governmentBean.setHeadOfGovernment(head);
                                break;
                            case "Suffrage:":
                                String[] suffrage = el.text().split("; |,");
                                String suffrageAge = removeParentheses(suffrage[0]);
                                governmentBean.setSuffrageAge(suffrageAge);

                                if (suffrage.length > 1 && suffrage[1].contains("compulsory"))
                                    governmentBean.setSuffrageCompulsory(true);
                                break;
                            case "time difference:":
                                governmentBean.setTimeDifference(removeParentheses( el.text() ));
                                break;
                            case "Legal system:":
                                governmentBean.setLegalSystem(el.text());
                                break;
                            case "National holiday:":
                                governmentBean.setNationalHoliday(el.text());
                                break;
                            case "Independence:":
                                governmentBean.setIndependenceDate(el.text());
                                break;
                            case "citizenship by birth:":
                                governmentBean.setCitizenshipByBirth(evalBool(el.text()));
                                break;
                            case "citizenship by descent only:":
                                governmentBean.setCitizenshipByDescent(el.text());
                                break;
                            case "dual citizenship recognized:":
                                governmentBean.setDualCitizenship(evalBool(el.text()));
                                break;
                            case "residency requirement for naturalization:":
                                governmentBean.setNaturalization(el.text());
                            case "daylight saving time:":
                                governmentBean.setDaylightSavingTime(el.text());
                                break;
                            case "geographic coordinates:":
                                if(!countryCode.equals("OD")){
                                    String[] capitalLoc = parseGeoCords(el.text());
                                    governmentBean.setCapitalLat(createDouble(capitalLoc[0]));
                                    governmentBean.setCapitalLng(createDouble(capitalLoc[1]));
                                }
                                else {
                                    governmentBean.setCapitalLat(04.51);
                                    governmentBean.setCapitalLng(31.37);
                                }
                                break;
                            default:
                                ;
                        }
                        break;

                    case "Economy":
                        economyBean.setCountryCode(countryCode);

                        switch (categoryTitle) {
                            case "Exchange rates:":

                                if(countryCode.equals("CY")){
                                    if(economyBean.getCurrencyText() == null){
                                        economyBean.setCurrencyText("euros (EUR) per US dollar -");
                                        economyBean.setExchangeRate(0.9214);
                                    }
                                }

                                else if(el.text().contains("per US dollar"))
                                    economyBean.setCurrencyText(el.text());

                                else if(el.text().contains("2016"))
                                    economyBean.setExchangeRate(createDouble( removeParentheses(el.text()) ));

                                break;

                            case "Economy - overview:":
                                econOverview = econOverview + el.text() + "\n";
                                break;

                            case "GDP - composition, by sector of origin:":
                                switch ( previous.text()){
                                    case "agriculture:":
                                        economyBean.setGDPAgriculture(createDouble(
                                                el.text().replace("%","") ));
                                        break;
                                    case "industry:":
                                        economyBean.setGDPIndustry(createDouble(
                                                el.text().replace("%","") ));
                                        break;
                                    case "services:":
                                        economyBean.setGDPServices(createDouble(removeParentheses(
                                                el.text().replace("%","") )));
                                        break;
                                    default:
                                        ;
                                }
                                break;

                            case "Labor force - by occupation:":
                                switch ( previous.text()){
                                    case "agriculture:":
                                        economyBean.setOccupationAgriculture(createDouble(
                                                el.text().replace("%","") ));
                                        break;
                                    case "industry:":
                                        economyBean.setOccupationIndustry(createDouble(
                                                el.text().replace("%","") ));
                                        break;
                                    case "services:":
                                        double occupationServices = createDouble( el.text().split("%")[0]);
                                        if(occupationServices < 100.0)
                                            economyBean.setOccupationServices(occupationServices);
                                        break;
                                    default:
                                        ;
                                }
                                break;

                            case "Household income or consumption by percentage share:":
                                if(previous.text().equals("lowest 10%:"))
                                    economyBean.setLowest10PCTConsumption(createDouble(
                                            el.text().replace("%","") ));

                                else if(previous.text().equals("highest 10%:"))
                                    economyBean.setHighest10PCTConsumption(createDouble(removeParentheses(
                                        el.text().replace("%","") )));

                                break;
                            default:
                                ;

                        }

                        switch (previous.text()) {

                            case "GDP (purchasing power parity):":
                                economyBean.setGDPPurchasingPowerParity( processValue(el.text()) );
                                break;
                            case "GDP (official exchange rate):":
                                economyBean.setGDPOfficialExchangeRate( processValue(el.text()) );
                                break;
                            case "GDP - real growth rate:":
                                economyBean.setGDPRealGrowthRate( createDouble(
                                        removeParentheses(el.text()).split("%")[0] ));
                                break;
                            case "GDP - per capita (PPP):":
                                String amount = removeParentheses(el.text()).replace("$","");
                                economyBean.setGDPPerCapita(createInt(amount));
                                break;
                            case "Gross national saving:":
                                economyBean.setGrossNationalSaving( createDouble(el.text().split("%")[0]) );
                                break;
                            case "household consumption:":
                                economyBean.setHouseholdConsumption(createDouble(
                                        el.text().replace("%","")) );
                                break;
                            case "government consumption:":
                                economyBean.setGovernmentConsumption(createDouble(
                                        el.text().replace("%","")) );
                                break;
                            case "investment in fixed capital:":
                                economyBean.setInvestmentFixedCapital(createDouble(
                                        el.text().replace("%","")) );
                                break;
                            case "investment in inventories:":
                                economyBean.setInvestmentInventories(createDouble(
                                        el.text().replace("%","")) );
                                break;
                            case "exports of goods and services:":
                                economyBean.setExports(createDouble(
                                        el.text().replace("%","")) );
                                break;
                            case "imports of goods and services:":
                                economyBean.setImports(createDouble(removeParentheses(
                                        el.text().replace("%","") )));
                                break;
                            case "Agriculture - products:":
                                economyBean.setAgricultureProducts( el.text() );
                                break;
                            case "Industries:":
                                economyBean.setIndustries( el.text() );
                                break;
                            case "Industrial production growth rate:":
                                economyBean.setIndustrialGrowth(createDouble(removeParentheses(
                                        el.text().replace("%","") )));
                                break;
                            case "Labor force:":
                                economyBean.setLaborForce(formatPopulation(removeParentheses(
                                        el.text() )));
                                break;
                            case "Unemployment rate:":
                                economyBean.setUnemploymentRate(createDouble(removeParentheses(
                                        el.text().replace("%","") )));
                                break;
                            case "Population below poverty line:":
                                economyBean.setBelowPovertyLine(createDouble(removeParentheses(
                                        el.text().replace("%","") )));
                                break;
                            case "Distribution of family income - Gini index:":
                                economyBean.setGiniIndexIncome(createDouble(removeParentheses(el.text() )));
                                break;
                            case "revenues:":
                                economyBean.setRevenues( processValue(el.text()) );
                                break;
                            case "expenditures:":
                                economyBean.setExpenditures( processValue( removeParentheses(el.text()) ));
                                break;
                            case "Taxes and other revenues:":
                                double taxes = createDouble( el.text().split("%")[0]);
                                if(taxes < 100.0)
                                    economyBean.setTaxes(taxes);
                                break;
                            case "Budget surplus (+) or deficit (-):":
                                economyBean.setBudgetSurplus(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Public debt:":
                                economyBean.setPublicDebt(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Fiscal year:":
                                economyBean.setFiscalYear(el.text());
                                break;
                            case "Inflation rate (consumer prices):":
                                economyBean.setInflation(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Central bank discount rate:":
                                economyBean.setCentralBankDiscount(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Commercial bank prime lending rate:":
                                economyBean.setCommercialBankLending( createDouble( el.text().split("%")[0] ) );
                                break;
                            case "Stock of narrow money:":
                                economyBean.setNarrowMoney(processValue(removeParentheses( el.text() )));
                                break;
                            case "Stock of broad money:":
                                economyBean.setBroadMoney(processValue(removeParentheses( el.text() )));
                                break;
                            case "Stock of domestic credit:":
                                economyBean.setDomesticCredit(processValue(removeParentheses( el.text() )));
                                break;
                            case "Market value of publicly traded shares:":
                                economyBean.setValueTradedShares(processValue(removeParentheses( el.text() )));
                                break;
                            case "Current account balance:":
                                economyBean.setCurrentAccountBalance(processValue(removeParentheses( el.text() )));
                                break;
                            case "Exports:":
                                economyBean.setExportsTotal(processValue(removeParentheses( el.text() )));
                                break;
                            case "Exports - commodities:":
                                economyBean.setExportsCommodities(el.text());
                                break;
                            case "Exports - partners:":
                                economyBean.setExportsPartners(el.text());
                                break;
                            case "Imports:":
                                economyBean.setImportsTotal(processValue(removeParentheses( el.text() )));
                                break;
                            case "Imports - commodities:":
                                economyBean.setImportsCommodities(el.text());
                                break;
                            case "Imports - partners:":
                                economyBean.setImportsPartners(el.text());
                                break;
                            case "Reserves of foreign exchange and gold:":
                                economyBean.setForeignGoldReserves(processValue(removeParentheses( el.text() )));
                                break;
                            case "Debt - external:":
                                economyBean.setDebtExternal(processValue(removeParentheses( el.text() )));
                                break;
                            case "Stock of direct foreign investment - at home:":
                                economyBean.setForeignInvestmentHome(processValue(removeParentheses( el.text() )));
                                break;
                            case "Stock of direct foreign investment - abroad:":
                                economyBean.setForeignInvestmentAbroad(processValue(removeParentheses( el.text() )));
                                break;
                            default:
                                ;
                        }
                        break;

                    case "Energy":
                        energyBean.setCountryCode(countryCode);

                        switch (previous.text()) {
                            case "population without electricity:":
                                energyBean.setWithoutElectricity(createInt(el.text()));
                                break;
                            case "electrification - total population:":
                                energyBean.setElectrificationPopulationPCT(createDouble( el.text().split("%")[0] ));
                                break;
                            case "electrification - urban areas:":
                                energyBean.setElectrificationUrbanPCT(createDouble( el.text().split("%")[0] ));
                            case "electrification - rural areas:":
                                energyBean.setElectrificationRuralPCT(createDouble( el.text().split("%")[0] ));
                            case "Electricity - production:":
                                energyBean.setElectricityProductionMillionskWh(energyRounderMillions(el.text()));
                                break;
                            case "Electricity - consumption:":
                                energyBean.setElectricityConsumptionMillionskWh(energyRounderMillions(el.text()));
                                break;
                            case "Electricity - exports:":
                                energyBean.setElectricityExportsMillionskWh(energyRounderMillions(el.text()));
                                break;
                            case "Electricity - imports:":
                                energyBean.setElectricityImportsMillionskWh(energyRounderMillions(el.text()));
                                break;
                            case "Electricity - installed generating capacity:":
                                energyBean.setElectricityCapacityThousandskW(energyRounderThounsands(el.text()));
                                break;
                            case "Electricity - from fossil fuels:":
                                energyBean.setElectricityFossilFuelsPCT(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Electricity - from nuclear fuels:":
                                energyBean.setElectricityNuclearFuelsPCT(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Electricity - from hydroelectric plants:":
                                energyBean.setElectricityHydroelectricPlantsPCT(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Electricity - from other renewable sources:":
                                energyBean.setElectricityOtherRenewableSourcesPCT(createDouble( el.text().split("%")[0] ));
                                break;
                            case "Crude oil - production:":
                                energyBean.setOilProductionBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Crude oil - exports:":
                                energyBean.setOilExportsBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Crude oil - imports:":
                                energyBean.setOilImportsBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Crude oil - proved reserves:":
                                energyBean.setOilProvedReservesThousandsBarrels(energyRounderThounsands(el.text()));
                                break;
                            case "Refined petroleum products - production:":
                                energyBean.setRefinedPetroleumProductionBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Refined petroleum products - consumption:":
                                energyBean.setRefinedPetroleumConsumptionBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Refined petroleum products - exports:":
                                energyBean.setRefinedPetroleumExportsBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Refined petroleum products - imports:":
                                energyBean.setRefinedPetroleumImportsBarrelsPerDay((int)processValue(el.text()));
                                break;
                            case "Natural gas - production:":
                                energyBean.setNaturalGasProductionMillionCubicMeters(energyRounderMillions(el.text()));
                                break;
                            case "Natural gas - consumption:":
                                energyBean.setNaturalGasConsumptionMillionCubicMeters(energyRounderMillions(el.text()));
                                break;
                            case "Natural gas - exports:":
                                energyBean.setNaturalGasExportsMillionCubicMeters(energyRounderMillions(el.text()));
                                break;
                            case "Natural gas - imports:":
                                energyBean.setNaturalGasImportsMillionCubicMeters(energyRounderMillions(el.text()));
                                break;
                            case "Natural gas - proved reserves:":
                                energyBean.setNaturalGasProvedReservesMillionCubicMeters(energyRounderMillions(el.text()));
                                break;
                            case "Carbon dioxide emissions from consumption of energy:":
                                energyBean.setCarbonDioxideEmissionsThousandsMetricTons(energyRounderThounsands(el.text()));
                                break;
                            default:
                                break;

                        }

                        break;

                    case "Communications":
                        communicationsBean.setCountryCode(countryCode);

                        switch (categoryTitle) {

                            case "Telephones - fixed lines:":
                                if(previous.text().equals("total subscriptions:"))
                                    communicationsBean.setTotalFixedLines((int)processValue(el.text()));

                                if(previous.text().equals("subscriptions per 100 inhabitants:"))
                                    communicationsBean.setFixedLinesPer100(createInt(removeParentheses(el.text())));

                                break;

                            case "Telephones - mobile cellular:":
                                if(previous.text().equals("total:"))
                                    communicationsBean.setTotalCellular((int)processValue(el.text()));

                                if(previous.text().equals("subscriptions per 100 inhabitants:"))
                                    communicationsBean.setCellularPer100(createInt(removeParentheses(el.text())));

                                break;

                            case "Internet users:":
                                if(previous.text().equals("total:"))
                                    communicationsBean.setInternetUsers((int)processValue(el.text()));

                                if(previous.text().equals("percent of population:"))
                                    communicationsBean.setInternetUsersPCT(createDouble( el.text().split("%")[0] ));
                                break;

                                default:
                                    ;
                        }

                        switch (previous.text()) {

                            case "general assessment:":
                                communicationsBean.setTelephoneGeneralAssessment(el.text());
                                break;
                            case "domestic:":
                                communicationsBean.setTelephoneSystemDomestic(el.text());
                                break;
                            case "international:":
                                communicationsBean.setTelephoneSystemInternational(el.text());
                                break;
                            case "Broadcast media:":
                                communicationsBean.setBroadcastMedia(el.text());
                                break;
                            case "Internet country code:":
                                if(countryCode.equals("FR"))
                                    communicationsBean.setInternetCode(".fr");
                                else
                                    communicationsBean.setInternetCode(el.text().split(";")[0]);

                            default:
                                ;
                        }



                    default:
                        ;
                }
            }

            previous = el;

        }
        countryBean.setCountryCode(countryCode);
        countryBean.setCountryName(countryName);
        countryBean.setRegion(region);
        countryBean.setIntroduction(introduction);
        economyBean.setOverview(econOverview);

        CountryMainManager.insert(countryBean);
        GeographyManager.insert(geoBean);
        SocietyManager.insert(societyBean);
        GovernmentManager.insert(governmentBean);
        EconomyManager.insert(economyBean);
        EnergyManager.insert(energyBean);
        CommunicationsManager.insert(communicationsBean);
    }

    private static String singleCountryName(String tempName){
        return tempName.charAt(0) + tempName.substring(1).toLowerCase();
    }

    private static String spacedCountryName(String tempName){
        String countryName = "";

        String[] nameParts	= tempName.split(" ");
        for(String part : nameParts){
            if(part.charAt(0) == '(')
                countryName = countryName + " (" + part.charAt(1) + part.substring(2).toLowerCase();
            else
                countryName = countryName + " " + part.charAt(0) + part.substring(1).toLowerCase();
        }

        return countryName.trim();
    }

    private static String hyphenedCountryName(String tempName){
        String countryName = "";

        String[] nameParts	= tempName.split("-");

        countryName = nameParts[0].charAt(0) + nameParts[0].substring(1).toLowerCase()
                + "-" + nameParts[1].charAt(0) + nameParts[1].substring(1).toLowerCase();

        return countryName;
    }

    private static String[] processElevation(String elevation){
        String[] elevArray = elevation.split("  | ");

        StringBuilder sb = new StringBuilder();
        int i = 2;

        //Avoids issue where the elevation has a numbered name
        if(Pattern.matches("[0-9]", Character.toString(elevArray[2].charAt(0)))){
            sb.append(elevArray[2]);
            i++;
        }

        while (!Pattern.matches("[0-9\\-]", Character.toString(elevArray[i].charAt(0)))){
            sb.append(" " + elevArray[i]);
            i++;
        }

        String elevName = sb.toString().trim();
        //System.out.println(elevName);

        //System.out.println(elevArray[i]);

        return new String[]{elevName,elevArray[i]};
    }

    private static ArrayList<Border> processBorders(String[] borders, String countryCode){
        ArrayList<Border> borderNations = new ArrayList<>();

        for(String border : borders){
            String[] borderData = border.trim().split("  | ");

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (Pattern.matches("[a-zA-Z]+", Character.toString(borderData[i].charAt(0)))){
                sb.append(" " + borderData[i]);
                i++;
            }
            String borderName = sb.toString();

            double borderKM = 0.0;
            try{
                borderKM = Double.parseDouble(borderData[i].replace(",",""));
            }catch(NumberFormatException e) {
                System.out.println("NumberFormatException: " + borderData[i]);

            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of bounds! " + countryCode);
            }

            if(!borderNations.isEmpty() &&
                              borderNations.get(borderNations.size()-1).getBorderCountry().equals(borderName) ){

                borderNations.get(borderNations.size()-1).setBorderLength(
                        borderNations.get(borderNations.size()-1).getBorderLength() + borderKM);

            } else {
                Border borderBean = new Border();
                borderBean.setCountryCode(countryCode);
                borderBean.setBorderCountry(borderName);
                borderBean.setBorderLength(borderKM);
                borderNations.add(borderBean);
            }
        }

        return borderNations;
    }

    private static ArrayList<City> processCities( String[] cities, String countryCode){

        ArrayList<City> cityBeans = new ArrayList<>();

        for( String city : cities){

            City cityBean = new City();
            cityBean.setCountryCode(countryCode);
            String[] cityData = city.trim().split(" ");

            //Determines City Name
            StringBuilder sb = new StringBuilder();
            for(String str : cityData){
                if (Pattern.matches("[a-zA-Z]+", Character.toString(str.charAt(0)) )){
                    sb.append(" " + str);
                }else
                    break;
            }
            cityBean.setCityName(sb.toString().trim());

            //Checks if a capital
            cityBean.setCapital(false);
            for(String str : cityData){
                if(str.equals("(capital)"))
                    cityBean.setCapital(true);
            }

            double number = 0;
            for(int i = 1; i<cityData.length; i++){
                try {
                    number = Double.parseDouble(cityData[i].replace(",",""));
                    if( i+1 < cityData.length && cityData[i+1].equals("million")){
                        number = number * 1000000;
                    }
                    cityBean.setPopulation((int)number);
                }
                catch(NumberFormatException e) {
                    //Should ignore failed attempts
                }
                if( number != 0.0)
                    break;
            }
            cityBeans.add(cityBean);
        }
        return cityBeans;
    }

    private static String removeParentheses(String str){

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        for(int i = 0; i<str.length(); i++){
            switch(str.charAt(i)){
                case '(':
                    flag = 1;
                    continue;
                case ')':
                    flag = 0;
                    continue;
            }
            if(flag==0)
                sb.append(str.charAt(i));
        }
        return sb.toString().trim();
    }

    private static String extractParentheses(String str){

        StringBuilder sb = new StringBuilder();
        int flag = 0;

        for(int i = 0; i<str.length(); i++){
            switch(str.charAt(i)){
                case '(':
                    flag = 1;
                    continue;
                case ')':
                    return sb.toString();
            }
            if(flag==1)
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    private static String[] parseGeoCords(String coordinates){
        String[] tempCoord = coordinates.split(",");
        String[] lat = tempCoord[0].trim().split(" ");
        String[] lng = tempCoord[1].trim().split(" ");

        StringBuilder sb = new StringBuilder();

        if(lat[2].equals("S"))
            sb.append("-");

        sb.append(lat[0] + "." + lat[1] + " ");

        if(lng[2].equals("W"))
            sb.append("-");

        sb.append(lng[0] + "." + lng[1]);

        return new String[]
                {(lat[2].equals("S") ? "-" : "") + lat[0] + "." + lat[1],
                 (lng[2].equals("W") ? "-" : "") + lng[0] + "." + lng[1]};
    }

    private static double createDouble( String number){
        double result = 0.0;
        try {
            result = Double.parseDouble(number.replace(",",""));
        }
        catch(NumberFormatException e) {
            if(!number.equals("NA")){
                //System.out.println(number + " could not be formatted to double");
            }
        }

        return result;
    }

    private static double processValue(String amount){

        String[] ftamount = removeParentheses(amount).replace("$","").split(" ");

        double value = createDouble(ftamount[0]);
        if(ftamount.length > 1){
            switch (ftamount[1]){
                case "million":
                    value = value * 1000000d;
                    break;
                case "billion":
                    value = value * 1000000000d;
                    break;
                case "trillion":
                    value = value * 1000000000000d;
                    break;
                default:
                    ;
            }
        }

        return value;
    }

    private static int energyRounderMillions(String amount){
        String[] ftamount = amount.split(" ");

        double value = createDouble(ftamount[0]);
        if(ftamount.length > 1){
            switch (ftamount[1]){
                case "million":
                    value = Math.round(value);
                    break;
                case "billion":
                    value = value * 1000;
                    break;
                case "trillion":
                    value = value * 1000000;
                    break;
                default:
                    if(value >= 1000){
                        System.out.println("Energy Rounder Millions must parse amount in thousands!");
                        value = value / 1000000;
                    }

                    break;
            }
        }

        return (int)value;
    }

    private static int energyRounderThounsands(String amount){
        String[] ftamount = amount.split(" ");

        double value = createDouble(ftamount[0]);
        if(ftamount.length > 1){
            switch (ftamount[1]){
                case "million":
                    value = value * 1000;
                    break;
                case "billion":
                    value = value * 1000000;
                    break;
                case "trillion":
                    System.out.println("Energy Rounder Thousands must parse amount in trillions!");
                    break;
                default:
                    if(value >= 1000)
                        value = value / 1000;
                    break;
            }
        }

        return (int)value;
    }

    private static int formatPopulation(String people){

        String[] peps = removeParentheses(people).split(" ");
        double amount = createDouble( peps[0] );
        if(peps.length > 1){
            switch (peps[1]) {
                case "million":
                    amount = amount * 1000000;
                    break;
            }
        }
        return (int)amount;
    }

    private static int createInt(String number){
        int result = 0;

        try{
            double temp = Double.parseDouble(number.replace(",",""));
            temp = Math.round(temp);
            result = (int)temp;
        }catch (NumberFormatException e){
            if(!number.equals("NA")){
                //System.out.println(number + " could not be formatted to integer");
            }
        }
        return result;
    }

    private static int[] ageStrucProcessing(String popData){
        String[] stats = extractParentheses(popData).split("/");
        return new int[]{
                createInt(stats[0].split(" ")[1]),
                createInt(stats[1].split(" ")[1])
        };
    }

    private static Boolean evalBool(String yesNo){
        return (yesNo.toUpperCase().equals("YES"));
    }
}
