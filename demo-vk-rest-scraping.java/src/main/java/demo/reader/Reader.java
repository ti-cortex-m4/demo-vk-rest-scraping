package demo.reader;

import demo.http.HttpRequester;

public class Reader<T> {

    private static final String URL_PREFIX = "https://api.vk.com/method/database.";
    private static final String URL_SUFFIX = "&lang=en&count=10000";

    private final HttpRequester<T> httpRequester;

    public Reader(Class<T> clazz) {
        this.httpRequester = new HttpRequester<>(clazz);
    }

    public T read(String urlBody) {
        return httpRequester.request(URL_PREFIX + urlBody + URL_SUFFIX);
    }
}
