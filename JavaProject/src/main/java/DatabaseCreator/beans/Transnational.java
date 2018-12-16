package DatabaseCreator.beans;

import java.io.Serializable;

public class Transnational implements Serializable {
    private static final long serialVersionUID = 7091017494705400690L;

    private String countryCode;
    private String disputes;
    private String refugees;
    private String iDPs;
    private String statelessPersons;
    private String traffickingSituation;
    private String traffickingTierRating;
    private String illicitDrugs;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDisputes() {
        return disputes;
    }

    public void setDisputes(String disputes) {
        this.disputes = disputes;
    }

    public String getRefugees() {
        return refugees;
    }

    public void setRefugees(String refugees) {
        this.refugees = refugees;
    }

    public String getIDPs() {
        return iDPs;
    }

    public void setIDPs(String iDPs) {
        this.iDPs = iDPs;
    }

    public String getStatelessPersons() {
        return statelessPersons;
    }

    public void setStatelessPersons(String statelessPersons) {
        this.statelessPersons = statelessPersons;
    }

    public String getTraffickingSituation() {
        return traffickingSituation;
    }

    public void setTraffickingSituation(String traffickingSituation) {
        this.traffickingSituation = traffickingSituation;
    }

    public String getTraffickingTierRating() {
        return traffickingTierRating;
    }

    public void setTraffickingTierRating(String traffickingTierRating) {
        this.traffickingTierRating = traffickingTierRating;
    }

    public String getIllicitDrugs() {
        return illicitDrugs;
    }

    public void setIllicitDrugs(String illicitDrugs) {
        this.illicitDrugs = illicitDrugs;
    }
}
