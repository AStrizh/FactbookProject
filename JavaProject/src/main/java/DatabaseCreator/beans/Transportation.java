package DatabaseCreator.beans;

import java.io.Serializable;

public class Transportation implements Serializable  {

    private static final long serialVersionUID = 6243484445548428817L;

    private int id;
    private String countryCode;
    private int registeredAirCarriers;
    private int airCarriersAircraft;
    private int airCarrierPassengers;
    private long airCarrierFreight;
    private int civilAircraftCode;
    private int totalAirports;
    private int pavedRunways;
    private int pavedOver3047m;
    private int pavedBetween2438TO3047m;
    private int pavedBetween1524TO2437m;
    private int pavedBetween914TO1523m;
    private int pavedUnder914m;
    private int unpavedRunways;
    private int unpavedOver3047m;
    private int unpavedBetween2438TO3047m;
    private int unpavedBetween1524TO2437m;
    private int unpavedBetween914TO1523m;
    private int unpavedUnder914m;
    private int heliports;
    private int pipelines;
    private int totalRailwayKM;
    private int broadGaugeKM;
    private int standardGaugeKM;
    private int narrowGaugeKM;
    private int dualGaugeKM;
    private int totalRoadwaysKM;
    private int pavedRoadwaysKM;
    private int unpavedRoadwaysKM;
    private int waterwaysKM;
    private int merchantMarine;
    private String merchantMarineType;
    private String foreignOwned;
    private String registeredInternationally;
    private String majorSeaport;
    private String riverPort;
    private String oilTerminal;
    private String dryCargoPort;
    private String containerPort;
    private String lNGTerminal;
    private String cruisePort;

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

    public int getRegisteredAirCarriers() {
        return registeredAirCarriers;
    }

    public void setRegisteredAirCarriers(int registeredAirCarriers) {
        this.registeredAirCarriers = registeredAirCarriers;
    }

    public int getAirCarriersAircraft() {
        return airCarriersAircraft;
    }

    public void setAirCarriersAircraft(int airCarriersAircraft) {
        this.airCarriersAircraft = airCarriersAircraft;
    }

    public int getAirCarrierPassengers() {
        return airCarrierPassengers;
    }

    public void setAirCarrierPassengers(int airCarrierPassengers) {
        this.airCarrierPassengers = airCarrierPassengers;
    }

    public long getAirCarrierFreight() {
        return airCarrierFreight;
    }

    public void setAirCarrierFreight(long airCarrierFreight) {
        this.airCarrierFreight = airCarrierFreight;
    }

    public int getCivilAircraftCode() {
        return civilAircraftCode;
    }

    public void setCivilAircraftCode(int civilAircraftCode) {
        this.civilAircraftCode = civilAircraftCode;
    }

    public int getTotalAirports() {
        return totalAirports;
    }

    public void setTotalAirports(int totalAirports) {
        this.totalAirports = totalAirports;
    }

    public int getPavedRunways() {
        return pavedRunways;
    }

    public void setPavedRunways(int pavedRunways) {
        this.pavedRunways = pavedRunways;
    }

    public int getPavedOver3047m() {
        return pavedOver3047m;
    }

    public void setPavedOver3047m(int pavedOver3047m) {
        this.pavedOver3047m = pavedOver3047m;
    }

    public int getPavedBetween2438TO3047m() {
        return pavedBetween2438TO3047m;
    }

    public void setPavedBetween2438TO3047m(int pavedBetween2438TO3047m) {
        this.pavedBetween2438TO3047m = pavedBetween2438TO3047m;
    }

    public int getPavedBetween1524TO2437m() {
        return pavedBetween1524TO2437m;
    }

    public void setPavedBetween1524TO2437m(int pavedBetween1524TO2437m) {
        this.pavedBetween1524TO2437m = pavedBetween1524TO2437m;
    }

    public int getPavedBetween914TO1523m() {
        return pavedBetween914TO1523m;
    }

    public void setPavedBetween914TO1523m(int pavedBetween914TO1523m) {
        this.pavedBetween914TO1523m = pavedBetween914TO1523m;
    }

    public int getPavedUnder914m() {
        return pavedUnder914m;
    }

    public void setPavedUnder914m(int pavedUnder914m) {
        this.pavedUnder914m = pavedUnder914m;
    }

    public int getUnpavedRunways() {
        return unpavedRunways;
    }

    public void setUnpavedRunways(int unpavedRunways) {
        this.unpavedRunways = unpavedRunways;
    }

    public int getUnpavedOver3047m() {
        return unpavedOver3047m;
    }

    public void setUnpavedOver3047m(int unpavedOver3047m) {
        this.unpavedOver3047m = unpavedOver3047m;
    }

    public int getUnpavedBetween2438TO3047m() {
        return unpavedBetween2438TO3047m;
    }

    public void setUnpavedBetween2438TO3047m(int unpavedBetween2438TO3047m) {
        this.unpavedBetween2438TO3047m = unpavedBetween2438TO3047m;
    }

    public int getUnpavedBetween1524TO2437m() {
        return unpavedBetween1524TO2437m;
    }

    public void setUnpavedBetween1524TO2437m(int unpavedBetween1524TO2437m) {
        this.unpavedBetween1524TO2437m = unpavedBetween1524TO2437m;
    }

    public int getUnpavedBetween914TO1523m() {
        return unpavedBetween914TO1523m;
    }

    public void setUnpavedBetween914TO1523m(int unpavedBetween914TO1523m) {
        this.unpavedBetween914TO1523m = unpavedBetween914TO1523m;
    }

    public int getUnpavedUnder914m() {
        return unpavedUnder914m;
    }

    public void setUnpavedUnder914m(int unpavedUnder914m) {
        this.unpavedUnder914m = unpavedUnder914m;
    }

    public int getHeliports() {
        return heliports;
    }

    public void setHeliports(int heliports) {
        this.heliports = heliports;
    }

    public int getPipelines() {
        return pipelines;
    }

    public void setPipelines(int pipelines) {
        this.pipelines = pipelines;
    }

    public int getTotalRailwayKM() {
        return totalRailwayKM;
    }

    public void setTotalRailwayKM(int totalRailwayKM) {
        this.totalRailwayKM = totalRailwayKM;
    }

    public int getBroadGaugeKM() {
        return broadGaugeKM;
    }

    public void setBroadGaugeKM(int broadGaugeKM) {
        this.broadGaugeKM = broadGaugeKM;
    }

    public int getStandardGaugeKM() {
        return standardGaugeKM;
    }

    public void setStandardGaugeKM(int standardGaugeKM) {
        this.standardGaugeKM = standardGaugeKM;
    }

    public int getNarrowGaugeKM() {
        return narrowGaugeKM;
    }

    public void setNarrowGaugeKM(int narrowGaugeKM) {
        this.narrowGaugeKM = narrowGaugeKM;
    }

    public int getDualGaugeKM() {
        return dualGaugeKM;
    }

    public void setDualGaugeKM(int dualGaugeKM) {
        this.dualGaugeKM = dualGaugeKM;
    }

    public int getTotalRoadwaysKM() {
        return totalRoadwaysKM;
    }

    public void setTotalRoadwaysKM(int totalRoadwaysKM) {
        this.totalRoadwaysKM = totalRoadwaysKM;
    }

    public int getPavedRoadwaysKM() {
        return pavedRoadwaysKM;
    }

    public void setPavedRoadwaysKM(int pavedRoadwaysKM) {
        this.pavedRoadwaysKM = pavedRoadwaysKM;
    }

    public int getUnpavedRoadwaysKM() {
        return unpavedRoadwaysKM;
    }

    public void setUnpavedRoadwaysKM(int unpavedRoadwaysKM) {
        this.unpavedRoadwaysKM = unpavedRoadwaysKM;
    }

    public int getWaterwaysKM() {
        return waterwaysKM;
    }

    public void setWaterwaysKM(int waterwaysKM) {
        this.waterwaysKM = waterwaysKM;
    }

    public int getMerchantMarine() {
        return merchantMarine;
    }

    public void setMerchantMarine(int merchantMarine) {
        this.merchantMarine = merchantMarine;
    }

    public String getMerchantMarineType() {
        return merchantMarineType;
    }

    public void setMerchantMarineType(String merchantMarineType) {
        this.merchantMarineType = merchantMarineType;
    }

    public String getForeignOwned() {
        return foreignOwned;
    }

    public void setForeignOwned(String foreignOwned) {
        this.foreignOwned = foreignOwned;
    }

    public String getRegisteredInternationally() {
        return registeredInternationally;
    }

    public void setRegisteredInternationally(String registeredInternationally) {
        this.registeredInternationally = registeredInternationally;
    }

    public String getMajorSeaport() {
        return majorSeaport;
    }

    public void setMajorSeaport(String majorSeaport) {
        this.majorSeaport = majorSeaport;
    }

    public String getRiverPort() {
        return riverPort;
    }

    public void setRiverPort(String riverPort) {
        this.riverPort = riverPort;
    }

    public String getOilTerminal() {
        return oilTerminal;
    }

    public void setOilTerminal(String oilTerminal) {
        this.oilTerminal = oilTerminal;
    }

    public String getDryCargoPort() {
        return dryCargoPort;
    }

    public void setDryCargoPort(String dryCargoPort) {
        this.dryCargoPort = dryCargoPort;
    }

    public String getContainerPort() {
        return containerPort;
    }

    public void setContainerPort(String containerPort) {
        this.containerPort = containerPort;
    }

    public String getLNGTerminal() {
        return lNGTerminal;
    }

    public void setLNGTerminal(String lNGTerminal) {
        this.lNGTerminal = lNGTerminal;
    }

    public String getCruisePort() {
        return cruisePort;
    }

    public void setCruisePort(String cruisePort) {
        this.cruisePort = cruisePort;
    }
}
