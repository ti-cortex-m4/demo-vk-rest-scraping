package demo.model

class University private constructor(val id: Int, val title: String) {

    var facultiesCount: Int? = null
        private set

    var faculties: List<Faculty>? = null
        set(faculties) {
            field = faculties
            this.facultiesCount = faculties!!.size
        }

    constructor(cm: ConstructorMediator) : this(cm.id, cm.title) {
    }

    override fun toString(): String {
        return "University{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
