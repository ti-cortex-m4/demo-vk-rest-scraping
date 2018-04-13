package demo.model

class City(item: Item) {

    val cid: Int
    val title: String

    var schoolsCount: Int? = null
        private set

    var schools: List<School>? = null
        set(schools) {
            field = schools
            this.schoolsCount = schools!!.size
        }

    var universitiesCount: Int? = null
        private set

    var universities: List<University>? = null
        set(universities) {
            field = universities
            this.universitiesCount = universities!!.size
        }

    init {
        this.cid = item.cid
        this.title = item.title!!
    }

    override fun toString(): String {
        return "City{" +
                "cid='" + cid + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
