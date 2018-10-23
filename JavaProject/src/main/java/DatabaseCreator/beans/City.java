package DatabaseCreator.beans;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = 3893680022967050766L;
    private int id;
    private String countryCode;
    private String cityName;
    private int population;
    private Boolean capital;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    @Override
    public String toString(){
        return countryCode +
               " " + cityName +
               " " + population +
               " " + capital;
    }
}
