package demo.model;

import com.google.api.client.util.Key;
import demo.reader.RepeatableReader;

import java.util.List;

public class ItemsList implements RepeatableReader.Responsive<List<Item>> {

    @Key("response")
    private List<Item> response;

    @Override
    public List<Item> response() {
        return response;
    }

    public void setResponse(List<Item> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ItemsList{" + "response.size=" + (response != null ? response.size() : "?") + '}';
    }
}
