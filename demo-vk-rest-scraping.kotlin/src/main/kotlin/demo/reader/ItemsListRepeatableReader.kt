package demo.reader

import demo.model.Item
import demo.model.ItemsList
import java.util.function.Function

class ItemsListRepeatableReader : RepeatableReader<ItemsList, Item>(ItemsList::class.java) {

    fun <T> read(urlBody: String, mapper: (Item) -> T): List<T> {
        return read(urlBody)
                .response()!!
                .map(mapper)
    }
}
