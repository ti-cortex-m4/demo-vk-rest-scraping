package demo.reader

open class RepeatableReader<T : RepeatableReader.Responsive<*>, S> internal constructor(clazz: Class<T>) : Reader<T>(clazz) {

    override fun read(urlBody: String): T {
        var answer: T
        do {
            answer = super.read(urlBody)
        } while (answer.response() == null)
        return answer
    }

    interface Responsive<out S> {

        fun response(): S?
    }
}
