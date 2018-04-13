package demo.model

import com.google.api.client.util.Key
import demo.reader.RepeatableReader

class ObjectsList : RepeatableReader.Responsive<List<Any>> {

    @Key("response")
    private var response: List<Any>? = null

    override fun response(): List<Any>? {
        return response
    }

    override fun toString(): String {
        return "ObjectsList{" + "response.size=" + (if (response != null) response!!.size else "?") + '}'
    }
}
