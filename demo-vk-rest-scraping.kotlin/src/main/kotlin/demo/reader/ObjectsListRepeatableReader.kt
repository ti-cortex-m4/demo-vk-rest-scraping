package demo.reader

import com.google.api.client.util.ArrayMap
import demo.model.ObjectsList

class ObjectsListRepeatableReader : RepeatableReader<ObjectsList, Any>(ObjectsList::class.java) {

    fun <T> read(urlBody: String, mapper: (ArrayMap<*, *>) -> T): List<T> {
        val list = read(urlBody)
                .response()!!

        return list.subList(1, list.size)
                .map({ `object` -> `object` as ArrayMap<*, *> })
                .map(mapper)
    }
}
