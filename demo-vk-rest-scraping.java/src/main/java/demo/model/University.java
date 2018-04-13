package demo.model;

import java.util.List;

public class University {

    private final int id;
    private final String title;

    private Integer facultiesCount;
    private List<Faculty> faculties;

    private University(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public University(ConstructorMediator cm) {
        this(cm.getId(), cm.getTitle());
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getFacultiesCount() {
        return facultiesCount;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
        this.facultiesCount = faculties.size();
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
