package demo.reader;

import com.google.api.client.util.ArrayMap;
import demo.model.ObjectsList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectsListRepeatableReader extends RepeatableReader<ObjectsList, Object> {

    public ObjectsListRepeatableReader() {
        super(ObjectsList.class);
    }

    public <T> List<T> read(String urlBody, Function<? super ArrayMap, T> mapper) {
        return read(urlBody)
                .response()
                .stream()
                .skip(1)
                .map(object -> (ArrayMap) object)
                .map(mapper)
                .collect(Collectors.toList());
    }
}
