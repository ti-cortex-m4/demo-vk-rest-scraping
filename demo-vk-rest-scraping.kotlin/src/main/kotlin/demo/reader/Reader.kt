package demo.reader

import demo.http.HttpRequester

open class Reader<T>(clazz: Class<T>) {

    private val httpRequester: HttpRequester<T>

    init {
        this.httpRequester = HttpRequester(clazz)
    }

    open fun read(urlBody: String): T {
        return httpRequester.request(URL_PREFIX + urlBody + URL_SUFFIX)
    }

    companion object {

        private val URL_PREFIX = "https://api.vk.com/method/database."
        private val URL_SUFFIX = "&lang=en&count=10000"
    }
}
