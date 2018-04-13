package demo.model

import com.google.api.client.util.ArrayMap

class ConstructorMediator(am: ArrayMap<*, *>) {

    val id: Int
    val title: String

    init {
        this.id = Integer.valueOf(am["id"].toString())!!
        this.title = am["title"].toString()
    }
}
