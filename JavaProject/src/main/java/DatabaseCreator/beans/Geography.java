package DatabaseCreator.beans;

public class Geography {

    private int id;
    private String countryCode;
    private double lat;
    private double lng;
    private int landArea;
    private int waterArea;
    private int landBoundaries;
    private int coastline;
    private int meanElevation;
    private int lowestPointDistance;
    private String lowestPointName;
    private int highestPointDistance;
    private String highestPointName;
    private int irrigatedLand;

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

    public int getLandArea() {
        return landArea;
    }

    public void setLandArea(int landArea) {
        this.landArea = landArea;
    }

    public int getWaterArea() {
        return waterArea;
    }

    public void setWaterArea(int waterArea) {
        this.waterArea = waterArea;
    }

    public int getLandBoundaries() {
        return landBoundaries;
    }

    public void setLandBoundaries(int landBoundaries) {
        this.landBoundaries = landBoundaries;
    }

    public int getCoastline() {
        return coastline;
    }

    public void setCoastline(int coastline) {
        this.coastline = coastline;
    }

    public int getMeanElevation() {
        return meanElevation;
    }

    public void setMeanElevation(int meanElevation) {
        this.meanElevation = meanElevation;
    }

    public int getLowestPointDistance() {
        return lowestPointDistance;
    }

    public void setLowestPointDistance(int lowestPointDistance) {
        this.lowestPointDistance = lowestPointDistance;
    }

    public String getLowestPointName() {
        return lowestPointName;
    }

    public void setLowestPointName(String lowestPointName) {
        this.lowestPointName = lowestPointName;
    }

    public int getHighestPointDistance() {
        return highestPointDistance;
    }

    public void setHighestPointDistance(int highestPointDistance) {
        this.highestPointDistance = highestPointDistance;
    }

    public String getHighestPointName() {
        return highestPointName;
    }

    public void setHighestPointName(String highestPointName) {
        this.highestPointName = highestPointName;
    }

    public int getIrrigatedLand() {
        return irrigatedLand;
    }

    public void setIrrigatedLand(int irrigatedLand) {
        this.irrigatedLand = irrigatedLand;
    }
}
