package demo.model;

import java.util.List;

public class Faculty {

    private final int id;
    private final String title;

    private Integer chairsCount;
    private List<Chair> chairs;

    private Faculty(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Faculty(ConstructorMediator cm) {
        this(cm.getId(), cm.getTitle());
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getChairsCount() {
        return chairsCount;
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
        this.chairsCount = chairs.size();
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
