package demo.model

class Country(item: Item) {

    val cid: Int
    val title: String

    var citiesCount: Int? = null
        private set

    var cities: List<City>? = null
        set(cities) {
            field = cities
            this.citiesCount = cities!!.size
        }

    init {
        this.cid = item.cid
        this.title = item.title!!
    }

    override fun toString(): String {
        return "Country{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
