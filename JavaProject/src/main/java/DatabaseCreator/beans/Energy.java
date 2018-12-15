package DatabaseCreator.beans;

import java.io.Serializable;

public class Energy implements Serializable {

    private static final long serialVersionUID = 9162180132800146891L;

    private int id;
    private String countryCode;
    private int withoutElectricity;
    private double electrificationPopulationPCT;
    private double electrificationUrbanPCT;
    private double electrificationRuralPCT;
    private int electricityProductionMillionskWh;
    private int electricityConsumptionMillionskWh;
    private int electricityExportsMillionskWh;
    private int electricityImportsMillionskWh;
    private int electricityCapacityThousandskW;
    private double electricityFossilFuelsPCT;
    private double electricityNuclearFuelsPCT;
    private double electricityHydroelectricPlantsPCT;
    private double electricityOtherRenewableSourcesPCT;

    private int oilProductionBarrelsPerDay;
    private int oilExportsBarrelsPerDay;
    private int oilImportsBarrelsPerDay;
    private int oilProvedReservesThousandsBarrels;
    private int refinedPetroleumProductionBarrelsPerDay;
    private int refinedPetroleumConsumptionBarrelsPerDay;
    private int refinedPetroleumExportsBarrelsPerDay;
    private int refinedPetroleumImportsBarrelsPerDay;

    private int naturalGasProductionMillionCubicMeters;
    private int naturalGasConsumptionMillionCubicMeters;
    private int naturalGasExportsMillionCubicMeters;
    private int naturalGasImportsMillionCubicMeters;
    private int naturalGasProvedReservesMillionCubicMeters;
    private int carbonDioxideEmissionsThousandsMetricTons;


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

    public int getWithoutElectricity() {
        return withoutElectricity;
    }

    public void setWithoutElectricity(int withoutElectricity) {
        this.withoutElectricity = withoutElectricity;
    }

    public double getElectrificationPopulationPCT() {
        return electrificationPopulationPCT;
    }

    public void setElectrificationPopulationPCT(double electrificationPopulationPCT) {
        this.electrificationPopulationPCT = electrificationPopulationPCT;
    }

    public double getElectrificationUrbanPCT() {
        return electrificationUrbanPCT;
    }

    public void setElectrificationUrbanPCT(double electrificationUrbanPCT) {
        this.electrificationUrbanPCT = electrificationUrbanPCT;
    }

    public double getElectrificationRuralPCT() {
        return electrificationRuralPCT;
    }

    public void setElectrificationRuralPCT(double electrificationRuralPCT) {
        this.electrificationRuralPCT = electrificationRuralPCT;
    }

    public int getElectricityProductionMillionskWh() {
        return electricityProductionMillionskWh;
    }

    public void setElectricityProductionMillionskWh(int electricityProductionMillionskWh) {
        this.electricityProductionMillionskWh = electricityProductionMillionskWh;
    }

    public int getElectricityConsumptionMillionskWh() {
        return electricityConsumptionMillionskWh;
    }

    public void setElectricityConsumptionMillionskWh(int electricityConsumptionMillionskWh) {
        this.electricityConsumptionMillionskWh = electricityConsumptionMillionskWh;
    }

    public int getElectricityExportsMillionskWh() {
        return electricityExportsMillionskWh;
    }

    public void setElectricityExportsMillionskWh(int electricityExportsMillionskWh) {
        this.electricityExportsMillionskWh = electricityExportsMillionskWh;
    }

    public int getElectricityImportsMillionskWh() {
        return electricityImportsMillionskWh;
    }

    public void setElectricityImportsMillionskWh(int electricityImportsMillionskWh) {
        this.electricityImportsMillionskWh = electricityImportsMillionskWh;
    }

    public int getElectricityCapacityThousandskW() {
        return electricityCapacityThousandskW;
    }

    public void setElectricityCapacityThousandskW(int electricityCapacityThousandskW) {
        this.electricityCapacityThousandskW = electricityCapacityThousandskW;
    }

    public double getElectricityFossilFuelsPCT() {
        return electricityFossilFuelsPCT;
    }

    public void setElectricityFossilFuelsPCT(double electricityFossilFuelsPCT) {
        this.electricityFossilFuelsPCT = electricityFossilFuelsPCT;
    }

    public double getElectricityNuclearFuelsPCT() {
        return electricityNuclearFuelsPCT;
    }

    public void setElectricityNuclearFuelsPCT(double electricityNuclearFuelsPCT) {
        this.electricityNuclearFuelsPCT = electricityNuclearFuelsPCT;
    }

    public double getElectricityHydroelectricPlantsPCT() {
        return electricityHydroelectricPlantsPCT;
    }

    public void setElectricityHydroelectricPlantsPCT(double electricityHydroelectricPlantsPCT) {
        this.electricityHydroelectricPlantsPCT = electricityHydroelectricPlantsPCT;
    }

    public double getElectricityOtherRenewableSourcesPCT() {
        return electricityOtherRenewableSourcesPCT;
    }

    public void setElectricityOtherRenewableSourcesPCT(double electricityOtherRenewableSourcesPCT) {
        this.electricityOtherRenewableSourcesPCT = electricityOtherRenewableSourcesPCT;
    }

    public int getOilProductionBarrelsPerDay() {
        return oilProductionBarrelsPerDay;
    }

    public void setOilProductionBarrelsPerDay(int oilProductionBarrelsPerDay) {
        this.oilProductionBarrelsPerDay = oilProductionBarrelsPerDay;
    }

    public int getOilExportsBarrelsPerDay() {
        return oilExportsBarrelsPerDay;
    }

    public void setOilExportsBarrelsPerDay(int oilExportsBarrelsPerDay) {
        this.oilExportsBarrelsPerDay = oilExportsBarrelsPerDay;
    }

    public int getOilImportsBarrelsPerDay() {
        return oilImportsBarrelsPerDay;
    }

    public void setOilImportsBarrelsPerDay(int oilImportsBarrelsPerDay) {
        this.oilImportsBarrelsPerDay = oilImportsBarrelsPerDay;
    }

    public int getOilProvedReservesThousandsBarrels() {
        return oilProvedReservesThousandsBarrels;
    }

    public void setOilProvedReservesThousandsBarrels(int oilProvedReservesThousandsBarrels) {
        this.oilProvedReservesThousandsBarrels = oilProvedReservesThousandsBarrels;
    }

    public int getRefinedPetroleumProductionBarrelsPerDay() {
        return refinedPetroleumProductionBarrelsPerDay;
    }

    public void setRefinedPetroleumProductionBarrelsPerDay(int refinedPetroleumProductionBarrelsPerDay) {
        this.refinedPetroleumProductionBarrelsPerDay = refinedPetroleumProductionBarrelsPerDay;
    }

    public int getRefinedPetroleumConsumptionBarrelsPerDay() {
        return refinedPetroleumConsumptionBarrelsPerDay;
    }

    public void setRefinedPetroleumConsumptionBarrelsPerDay(int refinedPetroleumConsumptionBarrelsPerDay) {
        this.refinedPetroleumConsumptionBarrelsPerDay = refinedPetroleumConsumptionBarrelsPerDay;
    }

    public int getRefinedPetroleumExportsBarrelsPerDay() {
        return refinedPetroleumExportsBarrelsPerDay;
    }

    public void setRefinedPetroleumExportsBarrelsPerDay(int refinedPetroleumExportsBarrelsPerDay) {
        this.refinedPetroleumExportsBarrelsPerDay = refinedPetroleumExportsBarrelsPerDay;
    }

    public int getRefinedPetroleumImportsBarrelsPerDay() {
        return refinedPetroleumImportsBarrelsPerDay;
    }

    public void setRefinedPetroleumImportsBarrelsPerDay(int refinedPetroleumImportsBarrelsPerDay) {
        this.refinedPetroleumImportsBarrelsPerDay = refinedPetroleumImportsBarrelsPerDay;
    }

    public int getNaturalGasProductionMillionCubicMeters() {
        return naturalGasProductionMillionCubicMeters;
    }

    public void setNaturalGasProductionMillionCubicMeters(int naturalGasProductionMillionCubicMeters) {
        this.naturalGasProductionMillionCubicMeters = naturalGasProductionMillionCubicMeters;
    }

    public int getNaturalGasConsumptionMillionCubicMeters() {
        return naturalGasConsumptionMillionCubicMeters;
    }

    public void setNaturalGasConsumptionMillionCubicMeters(int naturalGasConsumptionMillionCubicMeters) {
        this.naturalGasConsumptionMillionCubicMeters = naturalGasConsumptionMillionCubicMeters;
    }

    public int getNaturalGasExportsMillionCubicMeters() {
        return naturalGasExportsMillionCubicMeters;
    }

    public void setNaturalGasExportsMillionCubicMeters(int naturalGasExportsMillionCubicMeters) {
        this.naturalGasExportsMillionCubicMeters = naturalGasExportsMillionCubicMeters;
    }

    public int getNaturalGasImportsMillionCubicMeters() {
        return naturalGasImportsMillionCubicMeters;
    }

    public void setNaturalGasImportsMillionCubicMeters(int naturalGasImportsMillionCubicMeters) {
        this.naturalGasImportsMillionCubicMeters = naturalGasImportsMillionCubicMeters;
    }

    public int getNaturalGasProvedReservesMillionCubicMeters() {
        return naturalGasProvedReservesMillionCubicMeters;
    }

    public void setNaturalGasProvedReservesMillionCubicMeters(int naturalGasProvedReservesMillionCubicMeters) {
        this.naturalGasProvedReservesMillionCubicMeters = naturalGasProvedReservesMillionCubicMeters;
    }

    public int getCarbonDioxideEmissionsThousandsMetricTons() {
        return carbonDioxideEmissionsThousandsMetricTons;
    }

    public void setCarbonDioxideEmissionsThousandsMetricTons(int carbonDioxideEmissionsThousandsMetricTons) {
        this.carbonDioxideEmissionsThousandsMetricTons = carbonDioxideEmissionsThousandsMetricTons;
    }
}
