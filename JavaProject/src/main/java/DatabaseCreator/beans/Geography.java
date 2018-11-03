package DatabaseCreator.beans;

public class Geography {

    private int id;
    private String countryCode;
    private double lat;
    private double lng;
    private double landArea;
    private double waterArea;
    private double landBoundaries;
    private double coastline;
    private double meanElevation;
    private double lowestPointDistance;
    private String lowestPointName;
    private double highestPointDistance;
    private String highestPointName;
    private double irrigatedLand;

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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }


    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getWaterArea() {
        return waterArea;
    }

    public void setWaterArea(double waterArea) {
        this.waterArea = waterArea;
    }

    public double getLandBoundaries() {
        return landBoundaries;
    }

    public void setLandBoundaries(double landBoundaries) {
        this.landBoundaries = landBoundaries;
    }

    public double getCoastline() {
        return coastline;
    }

    public void setCoastline(double coastline) {
        this.coastline = coastline;
    }

    public double getMeanElevation() {
        return meanElevation;
    }

    public void setMeanElevation(double meanElevation) {
        this.meanElevation = meanElevation;
    }

    public double getLowestPointDistance() {
        return lowestPointDistance;
    }

    public void setLowestPointDistance(double lowestPointDistance) {
        this.lowestPointDistance = lowestPointDistance;
    }

    public String getLowestPointName() {
        return lowestPointName;
    }

    public void setLowestPointName(String lowestPointName) {
        this.lowestPointName = lowestPointName;
    }

    public double getHighestPointDistance() {
        return highestPointDistance;
    }

    public void setHighestPointDistance(double highestPointDistance) {
        this.highestPointDistance = highestPointDistance;
    }

    public String getHighestPointName() {
        return highestPointName;
    }

    public void setHighestPointName(String highestPointName) {
        this.highestPointName = highestPointName;
    }

    public double getIrrigatedLand() {
        return irrigatedLand;
    }

    public void setIrrigatedLand(double irrigatedLand) {
        this.irrigatedLand = irrigatedLand;
    }
}
