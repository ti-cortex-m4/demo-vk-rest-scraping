package demo.model;

import java.util.List;

public class Country {

    private final int cid;
    private final String title;

    private Integer citiesCount;
    private List<City> cities;

    public Country(Item item) {
        this.cid = item.getCid();
        this.title = item.getTitle();
    }

    public int getCid() {
        return cid;
    }

    public String getTitle() {
        return title;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
        this.citiesCount = cities.size();
    }

    public Integer getCitiesCount() {
        return citiesCount;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
