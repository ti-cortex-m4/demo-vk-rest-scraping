package demo.model;

import java.util.List;

public class City {

    private final int cid;
    private final String title;

    private Integer schoolsCount;
    private List<School> schools;

    private Integer universitiesCount;
    private List<University> universities;

    public City(Item item) {
        this.cid = item.getCid();
        this.title = item.getTitle();
    }

    public int getCid() {
        return cid;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSchoolsCount() {
        return schoolsCount;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
        this.schoolsCount = schools.size();
    }

    public Integer getUniversitiesCount() {
        return universitiesCount;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
        this.universitiesCount = universities.size();
    }

    @Override
    public String toString() {
        return "City{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
