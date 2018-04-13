package demo.model;

public class School {

    private final int id;
    private final String title;

    private School(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public School(ConstructorMediator cm) {
        this(cm.getId(), cm.getTitle());
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
