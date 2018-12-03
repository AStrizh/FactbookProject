package DatabaseCreator.beans;

import java.io.Serializable;

public class Society implements Serializable {

    private static final long serialVersionUID = -5168918568674715764L;
    private int id;
    private String countryCode;
    private int population;
    private int Male0_14;
    private int Female0_14;
    private int Male15_24;
    private int Female15_24;
    private int Male25_54;
    private int Female25_54;
    private int Male55_64;
    private int Female55_64;
    private int Male65;
    private int Female65;

    private double youthDependencyRatio;
    private double elderlyDependencyRatio;
    private double potentialSupportRatio;
    private double medianAgeMale;
    private double medianAgeFemale;
    private double populationGrowthRate;
    private double birthRatePer1K;
    private double deathRatePer1K;
    private double netMigrationRate;
    private int urbanPopulation;
    private double urbanizationRate;
    private double motherMeanAgeAtFirstBirth;
    private int maternalMortalityRatePer100K;
    private double infantMaleMortalityRatePer1K;
    private double infantFemaleMortalityRatePer1K;
    private double maleLifeExpectancy;
    private double femaleLifeExpectancy;
    private double childrenBornPerWoman;
    private double contraceptivePrevalencePCT;
    private double healthExpenditurePCT;
    private double physiciansPer1K;
    private double hospitalBedPer1K;

    private double improvedUrbanDrinkingWaterPCT;
    private double improvedRuralDrinkingWaterPCT;
    private double improvedUrbanSanitationFacilityAccessPCT;
    private double improvedRuralSanitationFacilityAccessPCT;
    private double improvedTotalSanitationFacilityAccessPCT;
    private double hIVAIDSPrevalencePCT;
    private int hIVAIDSAfflicted;
    private int hIVAIDSDeaths;
    private String infectiousDiseasesRisk;
    private double adultObesityPCT;
    private double educationExpenditures;
    private double maleLiteracy;
    private double femaleLiteracy;
    private int maleSchoolLifeExpectancy;
    private int femaleSchoolLifeExpectancy;
    private double maleUnemployment;
    private double femaleUnemployment;


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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getMale0_14() {
        return Male0_14;
    }

    public void setMale0_14(int male0_14) {
        Male0_14 = male0_14;
    }

    public int getFemale0_14() {
        return Female0_14;
    }

    public void setFemale0_14(int female0_14) {
        Female0_14 = female0_14;
    }

    public int getMale15_24() {
        return Male15_24;
    }

    public void setMale15_24(int male15_24) {
        Male15_24 = male15_24;
    }

    public int getFemale15_24() {
        return Female15_24;
    }

    public void setFemale15_24(int female15_24) {
        Female15_24 = female15_24;
    }

    public int getMale25_54() {
        return Male25_54;
    }

    public void setMale25_54(int male25_54) {
        Male25_54 = male25_54;
    }

    public int getFemale25_54() {
        return Female25_54;
    }

    public void setFemale25_54(int female25_54) {
        Female25_54 = female25_54;
    }

    public int getMale55_64() {
        return Male55_64;
    }

    public void setMale55_64(int male55_64) {
        Male55_64 = male55_64;
    }

    public int getFemale55_64() {
        return Female55_64;
    }

    public void setFemale55_64(int female55_64) {
        Female55_64 = female55_64;
    }

    public int getMale65() {
        return Male65;
    }

    public void setMale65(int male65) {
        Male65 = male65;
    }

    public int getFemale65() {
        return Female65;
    }

    public void setFemale65(int female65) {
        Female65 = female65;
    }

    public double getYouthDependencyRatio() {
        return youthDependencyRatio;
    }

    public void setYouthDependencyRatio(double youthDependencyRatio) {
        this.youthDependencyRatio = youthDependencyRatio;
    }

    public double getElderlyDependencyRatio() {
        return elderlyDependencyRatio;
    }

    public void setElderlyDependencyRatio(double elderlyDependencyRatio) {
        this.elderlyDependencyRatio = elderlyDependencyRatio;
    }

    public double getPotentialSupportRatio() {
        return potentialSupportRatio;
    }

    public void setPotentialSupportRatio(double potentialSupportRatio) {
        this.potentialSupportRatio = potentialSupportRatio;
    }

    public double getMedianAgeMale() {
        return medianAgeMale;
    }

    public void setMedianAgeMale(double medianAgeMale) {
        this.medianAgeMale = medianAgeMale;
    }

    public double getMedianAgeFemale() {
        return medianAgeFemale;
    }

    public void setMedianAgeFemale(double medianAgeFemale) {
        this.medianAgeFemale = medianAgeFemale;
    }

    public double getPopulationGrowthRate() {
        return populationGrowthRate;
    }

    public void setPopulationGrowthRate(double populationGrowthRate) {
        this.populationGrowthRate = populationGrowthRate;
    }

    public double getBirthRatePer1K() {
        return birthRatePer1K;
    }

    public void setBirthRatePer1K(double birthRatePer1K) {
        this.birthRatePer1K = birthRatePer1K;
    }

    public double getDeathRatePer1K() {
        return deathRatePer1K;
    }

    public void setDeathRatePer1K(double deathRate) {
        this.deathRatePer1K = deathRate;
    }

    public double getNetMigrationRate() {
        return netMigrationRate;
    }

    public void setNetMigrationRate(double netMigrationRate) {
        this.netMigrationRate = netMigrationRate;
    }

    public int getUrbanPopulation() {
        return urbanPopulation;
    }

    public void setUrbanPopulation(int urbanPopulation) {
        this.urbanPopulation = urbanPopulation;
    }

    public double getUrbanizationRate() {
        return urbanizationRate;
    }

    public void setUrbanizationRate(double urbanizationRate) {
        this.urbanizationRate = urbanizationRate;
    }

    public double getMotherMeanAgeAtFirstBirth() {
        return motherMeanAgeAtFirstBirth;
    }

    public void setMotherMeanAgeAtFirstBirth(double motherMeanAgeAtFirstBirth) {
        this.motherMeanAgeAtFirstBirth = motherMeanAgeAtFirstBirth;
    }

    public int getMaternalMortalityRatePer100K() {
        return maternalMortalityRatePer100K;
    }

    public void setMaternalMortalityRatePer100K(int maternalMortalityRatePer100K) {
        this.maternalMortalityRatePer100K = maternalMortalityRatePer100K;
    }

    public double getInfantMaleMortalityRatePer1K() {
        return infantMaleMortalityRatePer1K;
    }

    public void setInfantMaleMortalityRatePer1K(double infantMaleMortalityRatePer1K) {
        this.infantMaleMortalityRatePer1K = infantMaleMortalityRatePer1K;
    }

    public double getInfantFemaleMortalityRatePer1K() {
        return infantFemaleMortalityRatePer1K;
    }

    public void setInfantFemaleMortalityRatePer1K(double infantFemaleMortalityRatePer1K) {
        this.infantFemaleMortalityRatePer1K = infantFemaleMortalityRatePer1K;
    }

    public double getMaleLifeExpectancy() {
        return maleLifeExpectancy;
    }

    public void setMaleLifeExpectancy(double maleLifeExpectancy) {
        this.maleLifeExpectancy = maleLifeExpectancy;
    }

    public double getFemaleLifeExpectancy() {
        return femaleLifeExpectancy;
    }

    public void setFemaleLifeExpectancy(double femaleLifeExpectancy) {
        this.femaleLifeExpectancy = femaleLifeExpectancy;
    }

    public double getChildrenBornPerWoman() {
        return childrenBornPerWoman;
    }

    public void setChildrenBornPerWoman(double childrenBornPerWoman) {
        this.childrenBornPerWoman = childrenBornPerWoman;
    }

    public double getContraceptivePrevalencePCT() {
        return contraceptivePrevalencePCT;
    }

    public void setContraceptivePrevalencePCT(double contraceptivePrevalencePCT) {
        this.contraceptivePrevalencePCT = contraceptivePrevalencePCT;
    }

    public double getHealthExpenditurePCT() {
        return healthExpenditurePCT;
    }

    public void setHealthExpenditurePCT(double healthExpenditurePCT) {
        this.healthExpenditurePCT = healthExpenditurePCT;
    }

    public double getPhysiciansPer1K() {
        return physiciansPer1K;
    }

    public void setPhysiciansPer1K(double physiciansPer1K) {
        this.physiciansPer1K = physiciansPer1K;
    }

    public double getHospitalBedPer1K() {
        return hospitalBedPer1K;
    }

    public void setHospitalBedPer1K(double hospitalBedPer1K) {
        this.hospitalBedPer1K = hospitalBedPer1K;
    }

    public double getImprovedUrbanDrinkingWaterPCT() {
        return improvedUrbanDrinkingWaterPCT;
    }

    public void setImprovedUrbanDrinkingWaterPCT(double improvedUrbanDrinkingWaterPCT) {
        this.improvedUrbanDrinkingWaterPCT = improvedUrbanDrinkingWaterPCT;
    }

    public double getImprovedRuralDrinkingWaterPCT() {
        return improvedRuralDrinkingWaterPCT;
    }

    public void setImprovedRuralDrinkingWaterPCT(double improvedRuralDrinkingWaterPCT) {
        this.improvedRuralDrinkingWaterPCT = improvedRuralDrinkingWaterPCT;
    }

    public double getImprovedUrbanSanitationFacilityAccessPCT() {
        return improvedUrbanSanitationFacilityAccessPCT;
    }

    public void setImprovedUrbanSanitationFacilityAccessPCT(double improvedUrbanSanitationFacilityAccessPCT) {
        this.improvedUrbanSanitationFacilityAccessPCT = improvedUrbanSanitationFacilityAccessPCT;
    }

    public double getImprovedRuralSanitationFacilityAccessPCT() {
        return improvedRuralSanitationFacilityAccessPCT;
    }

    public void setImprovedRuralSanitationFacilityAccessPCT(double improvedRuralSanitationFacilityAccessPCT) {
        this.improvedRuralSanitationFacilityAccessPCT = improvedRuralSanitationFacilityAccessPCT;
    }

    public double getImprovedTotalSanitationFacilityAccessPCT() {
        return improvedTotalSanitationFacilityAccessPCT;
    }

    public void setImprovedTotalSanitationFacilityAccessPCT(double improvedTotalSanitationFacilityAccessPCT) {
        this.improvedTotalSanitationFacilityAccessPCT = improvedTotalSanitationFacilityAccessPCT;
    }

    public double gethIVAIDSPrevalencePCT() {
        return hIVAIDSPrevalencePCT;
    }

    public void sethIVAIDSPrevalencePCT(double hIVAIDSPrevalencePCT) {
        this.hIVAIDSPrevalencePCT = hIVAIDSPrevalencePCT;
    }

    public int gethIVAIDSAfflicted() {
        return hIVAIDSAfflicted;
    }

    public void sethIVAIDSAfflicted(int hIVAIDSAfflicted) {
        this.hIVAIDSAfflicted = hIVAIDSAfflicted;
    }

    public int gethIVAIDSDeaths() {
        return hIVAIDSDeaths;
    }

    public void sethIVAIDSDeaths(int hIVAIDSDeaths) {
        this.hIVAIDSDeaths = hIVAIDSDeaths;
    }

    public String getInfectiousDiseasesRisk() {
        return infectiousDiseasesRisk;
    }

    public void setInfectiousDiseasesRisk(String infectiousDiseasesRisk) {
        this.infectiousDiseasesRisk = infectiousDiseasesRisk;
    }

    public double getAdultObesityPCT() {
        return adultObesityPCT;
    }

    public void setAdultObesityPCT(double adultObesityPCT) {
        this.adultObesityPCT = adultObesityPCT;
    }

    public double getEducationExpenditures() {
        return educationExpenditures;
    }

    public void setEducationExpenditures(double educationExpenditures) {
        this.educationExpenditures = educationExpenditures;
    }

    public double getMaleLiteracy() {
        return maleLiteracy;
    }

    public void setMaleLiteracy(double maleLiteracy) {
        this.maleLiteracy = maleLiteracy;
    }

    public double getFemaleLiteracy() {
        return femaleLiteracy;
    }

    public void setFemaleLiteracy(double femaleLiteracy) {
        this.femaleLiteracy = femaleLiteracy;
    }

    public int getMaleSchoolLifeExpectancy() {
        return maleSchoolLifeExpectancy;
    }

    public void setMaleSchoolLifeExpectancy(int maleSchoolLifeExpectancy) {
        this.maleSchoolLifeExpectancy = maleSchoolLifeExpectancy;
    }

    public int getFemaleSchoolLifeExpectancy() {
        return femaleSchoolLifeExpectancy;
    }

    public void setFemaleSchoolLifeExpectancy(int femaleSchoolLifeExpectancy) {
        this.femaleSchoolLifeExpectancy = femaleSchoolLifeExpectancy;
    }

    public double getMaleUnemployment() {
        return maleUnemployment;
    }

    public void setMaleUnemployment(double maleUnemployment) {
        this.maleUnemployment = maleUnemployment;
    }

    public double getFemaleUnemployment() {
        return femaleUnemployment;
    }

    public void setFemaleUnemployment(double femaleUnemployment) {
        this.femaleUnemployment = femaleUnemployment;
    }
}
