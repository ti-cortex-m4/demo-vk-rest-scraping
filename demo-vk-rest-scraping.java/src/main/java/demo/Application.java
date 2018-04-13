package demo;

import demo.json.CountriesFile;
import demo.model.*;
import demo.reader.ItemsListRepeatableReader;
import demo.reader.ObjectsListRepeatableReader;
import demo.reader.Reader;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private final Reader<ItemsList> ITEMS_LIST_READER = new Reader<>(ItemsList.class);
    private final ItemsListRepeatableReader ITEMS_LIST_REPEATABLE_READER = new ItemsListRepeatableReader();
    private final ObjectsListRepeatableReader OBJECTS_LIST_REPEATABLE_READER = new ObjectsListRepeatableReader();

    public static void main(String[] args) throws Exception {
        Application application = new Application();

        application.readCountries();
        application.readCities();

        application.readUniversities();
        application.readFaculties();
        application.readChairs();

        application.readSchools();

        application.readSchoolsAndUniversities();
    }

    private boolean useCountry(Country country) {
        return true;
    }

    private void readCountries() {
        Set<Item> countries1 = new HashSet<>();
        countries1.addAll(ITEMS_LIST_READER.read("getCountries?need_all=1").response().stream().collect(Collectors.toList()));
        countries1.addAll(ITEMS_LIST_READER.read("getCountries?need_all=0").response().stream().collect(Collectors.toList()));

        List<Item> countries2 = new ArrayList<>(countries1);
        countries2.sort(Comparator.comparing(Item::getTitle));

        CountriesList countriesList = new CountriesList();
        countriesList.setCountries(countries2.stream().map(Country::new).filter(this::useCountry).collect(Collectors.toList()));

        new CountriesFile("reader/countries.json").save(countriesList);
    }

    private void readCities() {
        CountriesList countriesList = new CountriesFile("reader/countries.json").load();

        for (int countryIdx = 0; countryIdx < countriesList.getCountries().size(); countryIdx++) {
            Country country = countriesList.getCountries().get(countryIdx);
            if (useCountry(country)) {
                System.out.println(countryIdx + " / " + (countriesList.getCountries().size() - 1) + " " + country);

                country.setCities(
                        ITEMS_LIST_REPEATABLE_READER.read(
                                "getCities?country_id=" + country.getCid(),
                                City::new
                        )
                );
            }
        }

        new CountriesFile("reader/countries-cities.json").save(countriesList);
    }

    private void readUniversities() {
        CountriesList countriesList = new CountriesFile("reader/countries-cities.json").load();

        for (int countryIdx = 0; countryIdx < countriesList.getCountries().size(); countryIdx++) {
            Country country = countriesList.getCountries().get(countryIdx);
            if (useCountry(country)) {
                for (int cityIdx = 0; cityIdx < country.getCities().size(); cityIdx++) {
                    City city = country.getCities().get(cityIdx);

                    System.out.println(countryIdx + " / " + (countriesList.getCountries().size() - 1) + " " + country + " " + city);

                    city.setUniversities(
                            OBJECTS_LIST_REPEATABLE_READER.read(
                                    "getUniversities?city_id=" + city.getCid(),
                                    am -> new University(new ConstructorMediator(am))
                            )
                    );
                }
            }
        }

        new CountriesFile("reader/countries-cities-universities.json").save(countriesList);
    }

    private void readFaculties() {
        CountriesList countriesList = new CountriesFile("reader/countries-cities-universities.json").load();

        for (int countryIdx = 0; countryIdx < countriesList.getCountries().size(); countryIdx++) {
            Country country = countriesList.getCountries().get(countryIdx);
            if (useCountry(country)) {
                for (int cityIdx = 0; cityIdx < country.getCities().size(); cityIdx++) {
                    City city = country.getCities().get(cityIdx);

                    for (int universityIdx = 0; universityIdx < city.getUniversities().size(); universityIdx++) {
                        University university = city.getUniversities().get(universityIdx);

                        System.out.println(countryIdx + " / " + (countriesList.getCountries().size() - 1) + " " + country + " " + city + " " + university);

                        university.setFaculties(
                                OBJECTS_LIST_REPEATABLE_READER.read(
                                        "getFaculties?university_id=" + university.getId(),
                                        am -> new Faculty(new ConstructorMediator(am))
                                )
                        );
                    }
                }
            }
        }

        new CountriesFile("reader/countries-cities-universities-faculties.json").save(countriesList);
    }

    private void readChairs() {
        CountriesList countriesList = new CountriesFile("reader/countries-cities-universities-faculties.json").load();

        for (int countryIdx = 0; countryIdx < countriesList.getCountries().size(); countryIdx++) {
            Country country = countriesList.getCountries().get(countryIdx);
            if (useCountry(country)) {
                for (int cityIdx = 0; cityIdx < country.getCities().size(); cityIdx++) {
                    City city = country.getCities().get(cityIdx);

                    for (int universityIdx = 0; universityIdx < city.getUniversities().size(); universityIdx++) {
                        University university = city.getUniversities().get(universityIdx);

                        for (int facultyIdx = 0; facultyIdx < university.getFaculties().size(); facultyIdx++) {
                            Faculty faculty = university.getFaculties().get(facultyIdx);

                            System.out.println(countryIdx + " / " + (countriesList.getCountries().size() - 1) + " " + country + " " + city + " " + university + " " + faculty);

                            faculty.setChairs(
                                    OBJECTS_LIST_REPEATABLE_READER.read(
                                            "getFaculties?university_id=" + university.getId(),
                                            am -> new Chair(new ConstructorMediator(am))
                                    )
                            );
                        }
                    }
                }
            }
        }

        new CountriesFile("reader/countries-cities-universities-faculties-chairs.json").save(countriesList);
    }

    private void readSchools() {
        CountriesList countriesList = new CountriesFile("reader/countries-cities.json").load();

        for (int countryIdx = 0; countryIdx < countriesList.getCountries().size(); countryIdx++) {
            Country country = countriesList.getCountries().get(countryIdx);
            if (useCountry(country)) {
                for (int cityIdx = 0; cityIdx < country.getCities().size(); cityIdx++) {
                    City city = country.getCities().get(cityIdx);

                    System.out.println(countryIdx + " / " + (countriesList.getCountries().size() - 1) + " " + country + " " + city);

                    city.setSchools(
                            OBJECTS_LIST_REPEATABLE_READER.read(
                                    "getSchools?city_id=" + city.getCid(),
                                    am -> new School(new ConstructorMediator(am))
                            )
                    );
                }
            }
        }

        new CountriesFile("reader/countries-cities-schools.json").save(countriesList);
    }

    private void readSchoolsAndUniversities() {
        CountriesList countriesList = new CountriesFile("reader/countries-cities.json").load();

        for (int countryIdx = 0; countryIdx < countriesList.getCountries().size(); countryIdx++) {
            Country country = countriesList.getCountries().get(countryIdx);
            if (useCountry(country)) {
                for (int cityIdx = 0; cityIdx < country.getCities().size(); cityIdx++) {
                    City city = country.getCities().get(cityIdx);

                    System.out.println(countryIdx + " / " + (countriesList.getCountries().size() - 1) + " " + country + " " + city);

                    city.setSchools(
                            OBJECTS_LIST_REPEATABLE_READER.read(
                                    "getSchools?city_id=" + city.getCid(),
                                    am -> new School(new ConstructorMediator(am))
                            )
                    );

                    city.setUniversities(
                            OBJECTS_LIST_REPEATABLE_READER.read(
                                    "getUniversities?city_id=" + city.getCid(),
                                    am -> new University(new ConstructorMediator(am))
                            )
                    );
                }
            }
        }

        new CountriesFile("reader/countries-cities-schools,universities.json").save(countriesList);
    }
}

