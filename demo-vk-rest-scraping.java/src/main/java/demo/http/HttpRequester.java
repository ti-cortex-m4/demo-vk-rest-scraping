package demo.http;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;

public class HttpRequester<T> {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new GsonFactory();
    private static final HttpRequestFactory REQUEST_FACTORY = HTTP_TRANSPORT.createRequestFactory(request -> request.setParser(new JsonObjectParser(JSON_FACTORY)));

    private static final int TIMEOUT_10_MINUTES = 600_000;

    private final Class<T> clazz;

    public HttpRequester(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T request(String encodedUrl) {
        try {
            HttpRequest request = REQUEST_FACTORY.buildGetRequest(new GenericUrl(encodedUrl));
            request.setSuppressUserAgentSuffix(true);

            request.setConnectTimeout(TIMEOUT_10_MINUTES);
            request.setReadTimeout(TIMEOUT_10_MINUTES);

            HttpHeaders headers = new HttpHeaders();
            headers.setUserAgent(RandomUserAgent.getRandomUserAgent());
            request.setHeaders(headers);

            return request.execute().parseAs(clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
