package demo.json;

import demo.file.TextFile;
import demo.model.CountriesList;

public class CountriesFile {

    private final TextFile textFile;

    public CountriesFile(String fileName) {
        this.textFile = new TextFile(fileName);
    }

    public CountriesList load() {
        return CountriesSerializer.fromJson(textFile.load());
    }

    public void save(CountriesList countries) {
        textFile.save(CountriesSerializer.toJson(countries));
    }
}
