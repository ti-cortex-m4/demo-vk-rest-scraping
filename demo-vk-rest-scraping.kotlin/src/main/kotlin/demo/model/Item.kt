package demo.model

import com.google.api.client.util.Key

class Item {

    @Key("cid")
    var cid: Int = 0

    @Key("title")
    var title: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null || javaClass != other.javaClass)
            return false

        val item = other as Item?

        if (cid != item!!.cid)
            return false
        return title == item.title
    }

    override fun hashCode(): Int {
        var result = cid
        result = 31 * result + title!!.hashCode()
        return result
    }

    override fun toString(): String {
        return "Country{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
