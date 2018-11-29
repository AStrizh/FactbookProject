package DatabaseCreator.beans;

import java.io.Serializable;

public class Government  implements Serializable {

    private static final long serialVersionUID = -8932658330171437178L;
    private int id;
    private String countryCode;
    private String governmentType;
    private double capitalLat;
    private double capitalLng;
    private String timeDifference;
    private String daylightSavingTime;
    private String independenceDate;
    private String nationalHoliday;
    private String legalSystem;
    private Boolean citizenshipByBirth;
    private String citizenshipByDescent;
    private Boolean dualCitizenship;
    private String naturalization;
    private String suffrageAge;
    private Boolean suffrageCompulsory;
    private String chiefOfState;
    private String headOfGovernment;
    private String diplomatToUS;
    private String diplomatFromUS;

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

    public String getGovernmentType() {
        return governmentType;
    }

    public void setGovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    public double getCapitalLat() {
        return capitalLat;
    }

    public void setCapitalLat(double capitalLat) {
        this.capitalLat = capitalLat;
    }

    public double getCapitalLng() {
        return capitalLng;
    }

    public void setCapitalLng(double capitalLng) {
        this.capitalLng = capitalLng;
    }

    public String getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(String timeDifference) {
        this.timeDifference = timeDifference;
    }

    public String getDaylightSavingTime() {
        return daylightSavingTime;
    }

    public void setDaylightSavingTime(String daylightSavingTime) {
        this.daylightSavingTime = daylightSavingTime;
    }

    public String getIndependenceDate() {
        return independenceDate;
    }

    public void setIndependenceDate(String independenceDate) {
        this.independenceDate = independenceDate;
    }

    public String getNationalHoliday() {
        return nationalHoliday;
    }

    public void setNationalHoliday(String nationalHoliday) {
        this.nationalHoliday = nationalHoliday;
    }

    public String getLegalSystem() {
        return legalSystem;
    }

    public void setLegalSystem(String legalSystem) {
        this.legalSystem = legalSystem;
    }

    public Boolean getCitizenshipByBirth() {
        return citizenshipByBirth;
    }

    public void setCitizenshipByBirth(Boolean citizenshipByBirth) {
        this.citizenshipByBirth = citizenshipByBirth;
    }

    public String getCitizenshipByDescent() {
        return citizenshipByDescent;
    }

    public void setCitizenshipByDescent(String citizenshipByDescent) {
        this.citizenshipByDescent = citizenshipByDescent;
    }

    public Boolean getDualCitizenship() {
        return dualCitizenship;
    }

    public void setDualCitizenship(Boolean dualCitizenship) {
        this.dualCitizenship = dualCitizenship;
    }

    public String getNaturalization() {
        return naturalization;
    }

    public void setNaturalization(String naturalization) {
        this.naturalization = naturalization;
    }

    public String getSuffrageAge() {
        return suffrageAge;
    }

    public void setSuffrageAge(String suffrageAge) {
        this.suffrageAge = suffrageAge;
    }

    public Boolean getSuffrageCompulsory() {
        return suffrageCompulsory;
    }

    public void setSuffrageCompulsory(Boolean suffrageCompulsory) {
        this.suffrageCompulsory = suffrageCompulsory;
    }

    public String getChiefOfState() {
        return chiefOfState;
    }

    public void setChiefOfState(String chiefOfState) {
        this.chiefOfState = chiefOfState;
    }

    public String getHeadOfGovernment() {
        return headOfGovernment;
    }

    public void setHeadOfGovernment(String headOfGovernment) {
        this.headOfGovernment = headOfGovernment;
    }

    public String getDiplomatToUS() {
        return diplomatToUS;
    }

    public void setDiplomatToUS(String diplomatToUS) {
        this.diplomatToUS = diplomatToUS;
    }

    public String getDiplomatFromUS() {
        return diplomatFromUS;
    }

    public void setDiplomatFromUS(String diplomatFromUS) {
        this.diplomatFromUS = diplomatFromUS;
    }
}