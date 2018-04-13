package demo.reader;

import demo.model.Item;
import demo.model.ItemsList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemsListRepeatableReader extends RepeatableReader<ItemsList, Item> {

    public ItemsListRepeatableReader() {
        super(ItemsList.class);
    }

    public <T> List<T> read(String urlBody, Function<? super Item, T> mapper) {
        return read(urlBody)
                .response()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
