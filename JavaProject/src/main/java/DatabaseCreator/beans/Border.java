package DatabaseCreator.beans;

import java.io.Serializable;

public class Border implements Serializable {

    private static final long serialVersionUID = 4516459214599532237L;
    private int id;
    private String countryCode;
    private String borderCountry;
    private double borderLength;

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

    public String getBorderCountry() {
        return borderCountry;
    }

    public void setBorderCountry(String borderCountry) {
        this.borderCountry = borderCountry;
    }

    public double getBorderLength() {
        return borderLength;
    }

    public void setBorderLength(double borderLength) {
        this.borderLength = borderLength;
    }
}
