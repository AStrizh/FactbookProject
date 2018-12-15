package DatabaseCreator.beans;

import java.io.Serializable;

public class Communications implements Serializable {

    private static final long serialVersionUID = 544685413023482061L;

    private int id;
    private String countryCode;
    private int totalFixedLines;
    private int fixedLinesPer100;
    private int totalCellular;
    private int cellularPer100;
    private String telephoneGeneralAssessment;
    private String telephoneSystemDomestic;
    private String telephoneSystemInternational;
    private String broadcastMedia;
    private String internetCode;
    private int internetUsers;
    private double internetUsersPCT;

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

    public int getTotalFixedLines() {
        return totalFixedLines;
    }

    public void setTotalFixedLines(int totalFixedLines) {
        this.totalFixedLines = totalFixedLines;
    }

    public int getFixedLinesPer100() {
        return fixedLinesPer100;
    }

    public void setFixedLinesPer100(int fixedLinesPer100) {
        this.fixedLinesPer100 = fixedLinesPer100;
    }

    public int getTotalCellular() {
        return totalCellular;
    }

    public void setTotalCellular(int totalCellular) {
        this.totalCellular = totalCellular;
    }

    public int getCellularPer100() {
        return cellularPer100;
    }

    public void setCellularPer100(int cellularPer100) {
        this.cellularPer100 = cellularPer100;
    }

    public String getTelephoneGeneralAssessment() {
        return telephoneGeneralAssessment;
    }

    public void setTelephoneGeneralAssessment(String telephoneGeneralAssessment) {
        this.telephoneGeneralAssessment = telephoneGeneralAssessment;
    }

    public String getTelephoneSystemDomestic() {
        return telephoneSystemDomestic;
    }

    public void setTelephoneSystemDomestic(String telephoneSystemDomestic) {
        this.telephoneSystemDomestic = telephoneSystemDomestic;
    }

    public String getTelephoneSystemInternational() {
        return telephoneSystemInternational;
    }

    public void setTelephoneSystemInternational(String telephoneSystemInternational) {
        this.telephoneSystemInternational = telephoneSystemInternational;
    }

    public String getBroadcastMedia() {
        return broadcastMedia;
    }

    public void setBroadcastMedia(String broadcastMedia) {
        this.broadcastMedia = broadcastMedia;
    }

    public String getInternetCode() {
        return internetCode;
    }

    public void setInternetCode(String internetCode) {
        this.internetCode = internetCode;
    }

    public int getInternetUsers() {
        return internetUsers;
    }

    public void setInternetUsers(int internetUsers) {
        this.internetUsers = internetUsers;
    }

    public double getInternetUsersPCT() {
        return internetUsersPCT;
    }

    public void setInternetUsersPCT(double internetUsersPCT) {
        this.internetUsersPCT = internetUsersPCT;
    }
}
