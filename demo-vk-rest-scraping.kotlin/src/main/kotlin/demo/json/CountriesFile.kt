package demo.json

import demo.model.CountriesList
import demo.file.TextFile

class CountriesFile(fileName: String) {

    private val textFile: TextFile

    init {
        this.textFile = TextFile(fileName)
    }

    fun load(): CountriesList {
        return CountriesSerializer.fromJson(textFile.load())
    }

    fun save(countries: CountriesList) {
        textFile.save(CountriesSerializer.toJson(countries))
    }
}
