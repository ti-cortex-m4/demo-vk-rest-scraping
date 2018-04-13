package demo.model;

import com.google.api.client.util.ArrayMap;

public class ConstructorMediator {

    private final int id;
    private final String title;

    public ConstructorMediator(ArrayMap am) {
        this.id = Integer.valueOf(am.get("id").toString());
        this.title = am.get("title").toString();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
