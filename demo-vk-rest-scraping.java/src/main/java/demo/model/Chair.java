package demo.model;

public class Chair {

    private final int id;
    private final String title;

    private Chair(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Chair(ConstructorMediator cm) {
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
        return "Chair{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
