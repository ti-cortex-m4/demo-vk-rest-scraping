package demo.model;

import com.google.api.client.util.Key;

public class Item {

    @Key("cid")
    private int cid;

    @Key("title")
    private String title;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Item item = (Item) obj;

        if (cid != item.cid)
            return false;
        return title.equals(item.title);
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
