package demo.model;

import com.google.api.client.util.Key;
import demo.reader.RepeatableReader;

import java.util.List;

public class ObjectsList implements RepeatableReader.Responsive<List<Object>> {

    @Key("response")
    private List<Object> response;

    @Override
    public List<Object> response() {
        return response;
    }

    public void setResponse(List<Object> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ObjectsList{" + "response.size=" + (response != null ? response.size() : "?") + '}';
    }
}
