package demo.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import demo.model.CountriesList;

class CountriesSerializer {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    static CountriesList fromJson(String json) {
        return GSON.fromJson(json, CountriesList.class);
    }

    static String toJson(CountriesList countries) {
        return GSON.toJson(countries);
    }
}
