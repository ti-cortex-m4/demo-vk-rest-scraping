package demo.model;

import java.util.List;

public class CountriesList {

    private Integer countriesCount;
    private List<Country> countries;

    public CountriesList() {
    }

    public CountriesList(List<Country> countries) {
        this.countries = countries;
        this.countriesCount = countries.size();
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
        this.countriesCount = countries.size();
    }

    public Integer getCountriesCount() {
        return countriesCount;
    }
}
