package demo.model

class Faculty private constructor(val id: Int, val title: String) {

    var chairsCount: Int? = null
        private set

    var chairs: List<Chair>? = null
        set(chairs) {
            field = chairs
            this.chairsCount = chairs!!.size
        }

    constructor(cm: ConstructorMediator) : this(cm.id, cm.title) {
    }

    override fun toString(): String {
        return "Faculty{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
