package demo.json

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import demo.model.CountriesList

internal object CountriesSerializer {

    private val GSON = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()

    fun fromJson(json: String): CountriesList {
        return GSON.fromJson(json, CountriesList::class.java)
    }

    fun toJson(countries: CountriesList): String {
        return GSON.toJson(countries)
    }
}
