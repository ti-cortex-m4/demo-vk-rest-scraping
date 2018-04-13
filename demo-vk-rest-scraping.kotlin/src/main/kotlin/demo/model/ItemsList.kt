package demo.model

import com.google.api.client.util.Key
import demo.reader.RepeatableReader

class ItemsList : RepeatableReader.Responsive<List<Item>> {

    @Key("response")
    private var response: List<Item>? = null

    override fun response(): List<Item>? {
        return response
    }

    override fun toString(): String {
        return "ItemsList{" + "response.size=" + (if (response != null) response!!.size else "?") + '}'
    }
}
