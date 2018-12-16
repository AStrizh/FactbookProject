package DatabaseCreator.beans;

import java.io.Serializable;

public class Military implements Serializable {

    private static final long serialVersionUID = -5725531134591346614L;

    public String countryCode;
    public double militaryExpenditure;
    public String militaryObligation;
    public String militaryBranches;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getMilitaryExpenditure() {
        return militaryExpenditure;
    }

    public void setMilitaryExpenditure(double militaryExpenditure) {
        this.militaryExpenditure = militaryExpenditure;
    }

    public String getMilitaryObligation() {
        return militaryObligation;
    }

    public void setMilitaryObligation(String militaryObligation) {
        this.militaryObligation = militaryObligation;
    }

    public String getMilitaryBranches() {
        return militaryBranches;
    }

    public void setMilitaryBranches(String militaryBranches) {
        this.militaryBranches = militaryBranches;
    }
}
