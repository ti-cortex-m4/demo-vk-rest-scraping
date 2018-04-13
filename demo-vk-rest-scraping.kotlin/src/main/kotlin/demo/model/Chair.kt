package demo.model

class Chair private constructor(val id: Int, val title: String) {

    constructor(cm: ConstructorMediator) : this(cm.id, cm.title) {
    }

    override fun toString(): String {
        return "Chair{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}'
    }
}
