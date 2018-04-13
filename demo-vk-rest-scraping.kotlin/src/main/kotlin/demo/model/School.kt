package demo.model

class School private constructor(val id: Int, val title: String) {

    constructor(cm: ConstructorMediator) : this(cm.id, cm.title) {
    }

    override fun toString(): String {
        return "School{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
