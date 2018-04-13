package demo.http

import com.google.api.client.http.GenericUrl
import com.google.api.client.http.HttpHeaders
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonObjectParser
import com.google.api.client.json.gson.GsonFactory

class HttpRequester<T>(private val clazz: Class<T>) {

    private val HTTP_TRANSPORT = NetHttpTransport()
    private val JSON_FACTORY = GsonFactory()
    private val REQUEST_FACTORY = HTTP_TRANSPORT.createRequestFactory({ request -> request.parser = JsonObjectParser(JSON_FACTORY) })

    private val TIMEOUT_10_MINUTES = 600000

    fun request(encodedUrl: String): T {
        val request = REQUEST_FACTORY.buildGetRequest(GenericUrl(encodedUrl))
        request.suppressUserAgentSuffix = true

        request.connectTimeout = TIMEOUT_10_MINUTES
        request.readTimeout = TIMEOUT_10_MINUTES

        val headers = HttpHeaders()
        headers.userAgent = RandomUserAgent.getRandomUserAgent()
        request.headers = headers

        return request.execute().parseAs(clazz)
    }
}
