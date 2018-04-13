package demo

import demo.json.CountriesFile
import demo.model.*
import demo.reader.ItemsListRepeatableReader
import demo.reader.ObjectsListRepeatableReader
import demo.reader.Reader
import java.util.*

class Application {

    private val ITEMS_LIST_READER = Reader(ItemsList::class.java)
    private val ITEMS_LIST_REPEATABLE_READER = ItemsListRepeatableReader()
    private val OBJECTS_LIST_REPEATABLE_READER = ObjectsListRepeatableReader()

    private fun useCountry(country: Country): Boolean {
        return true
    }

    private fun readCountries() {
        val countries1 = HashSet<Item>()
        countries1.addAll(ITEMS_LIST_READER.read("getCountries?need_all=1").response()!!)
        countries1.addAll(ITEMS_LIST_READER.read("getCountries?need_all=0").response()!!)

        val countries2 = ArrayList(countries1)
        countries2.sort(Comparator.comparing<Item, String>({ item -> item.title }))

        val countriesList = CountriesList()
        countriesList.countries = countries2.map({ item -> Country(item) }).filter({ country -> this.useCountry(country) }).toMutableList()

        CountriesFile("reader/countries.json").save(countriesList)
    }

    private fun readCities() {
        val countriesList = CountriesFile("reader/countries.json").load()

        for (countryIdx in 0..countriesList.countries!!.size - 1) {
            val country = countriesList.countries!![countryIdx]
            if (useCountry(country)) {
                println(countryIdx.toString() + " / " + (countriesList.countries!!.size - 1) + " " + country)

                country.cities = ITEMS_LIST_REPEATABLE_READER.read<City>(
                        "getCities?country_id=" + country.cid,
                        { item -> City(item) }
                )
            }
        }

        CountriesFile("reader/countries-cities.json").save(countriesList)
    }

    private fun readUniversities() {
        val countriesList = CountriesFile("reader/countries-cities.json").load()

        for (countryIdx in 0..countriesList.countries!!.size - 1) {
            val country = countriesList.countries!![countryIdx]
            if (useCountry(country)) {
                for (cityIdx in 0..country.cities!!.size - 1) {
                    val city = country.cities!![cityIdx]

                    println(countryIdx.toString() + " / " + (countriesList.countries!!.size - 1) + " " + country + " " + city)

                    city.universities = OBJECTS_LIST_REPEATABLE_READER.read(
                            "getUniversities?city_id=" + city.cid,
                            { am -> University(ConstructorMediator(am)) }
                    )
                }
            }
        }

        CountriesFile("reader/countries-cities-universities.json").save(countriesList)
    }

    private fun readFaculties() {
        val countriesList = CountriesFile("reader/countries-cities-universities.json").load()

        for (countryIdx in 0..countriesList.countries!!.size - 1) {
            val country = countriesList.countries!![countryIdx]
            if (useCountry(country)) {
                for (cityIdx in 0..country.cities!!.size - 1) {
                    val city = country.cities!![cityIdx]

                    for (universityIdx in 0..city.universities!!.size - 1) {
                        val university = city.universities!![universityIdx]

                        println(countryIdx.toString() + " / " + (countriesList.countries!!.size - 1) + " " + country + " " + city + " " + university)

                        university.faculties = OBJECTS_LIST_REPEATABLE_READER.read(
                                "getFaculties?university_id=" + university.id,
                                { am -> Faculty(ConstructorMediator(am)) }
                        )
                    }
                }
            }
        }

        CountriesFile("reader/countries-cities-universities-faculties.json").save(countriesList)
    }

    private fun readChairs() {
        val countriesList = CountriesFile("reader/countries-cities-universities-faculties.json").load()

        for (countryIdx in 0..countriesList.countries!!.size - 1) {
            val country = countriesList.countries!![countryIdx]
            if (useCountry(country)) {
                for (cityIdx in 0..country.cities!!.size - 1) {
                    val city = country.cities!![cityIdx]

                    for (universityIdx in 0..city.universities!!.size - 1) {
                        val university = city.universities!![universityIdx]

                        for (facultyIdx in 0..university.faculties!!.size - 1) {
                            val faculty = university.faculties!![facultyIdx]

                            println(countryIdx.toString() + " / " + (countriesList.countries!!.size - 1) + " " + country + " " + city + " " + university + " " + faculty)

                            faculty.chairs = OBJECTS_LIST_REPEATABLE_READER.read(
                                    "getFaculties?university_id=" + university.id,
                                    { am -> Chair(ConstructorMediator(am)) }
                            )
                        }
                    }
                }
            }
        }

        CountriesFile("reader/countries-cities-universities-faculties-chairs.json").save(countriesList)
    }

    private fun readSchools() {
        val countriesList = CountriesFile("reader/countries-cities.json").load()

        for (countryIdx in 0..countriesList.countries!!.size - 1) {
            val country = countriesList.countries!![countryIdx]
            if (useCountry(country)) {
                for (cityIdx in 0..country.cities!!.size - 1) {
                    val city = country.cities!![cityIdx]

                    println(countryIdx.toString() + " / " + (countriesList.countries!!.size - 1) + " " + country + " " + city)

                    city.schools = OBJECTS_LIST_REPEATABLE_READER.read(
                            "getSchools?city_id=" + city.cid,
                            { am -> School(ConstructorMediator(am)) }
                    )
                }
            }
        }

        CountriesFile("reader/countries-cities-schools.json").save(countriesList)
    }

    private fun readSchoolsAndUniversities() {
        val countriesList = CountriesFile("reader/countries-cities.json").load()

        for (countryIdx in 0..countriesList.countries!!.size - 1) {
            val country = countriesList.countries!![countryIdx]
            if (useCountry(country)) {
                for (cityIdx in 0..country.cities!!.size - 1) {
                    val city = country.cities!![cityIdx]

                    println(countryIdx.toString() + " / " + (countriesList.countries!!.size - 1) + " " + country + " " + city)

                    city.schools = OBJECTS_LIST_REPEATABLE_READER.read(
                            "getSchools?city_id=" + city.cid,
                            { am -> School(ConstructorMediator(am)) }
                    )

                    city.universities = OBJECTS_LIST_REPEATABLE_READER.read(
                            "getUniversities?city_id=" + city.cid,
                            { am -> University(ConstructorMediator(am)) }
                    )
                }
            }
        }

        CountriesFile("reader/countries-cities-schools,universities.json").save(countriesList)
    }

    companion object {

        @JvmStatic fun main(args: Array<String>) {
            val application = Application()

            application.readCountries()
            application.readCities()

            application.readUniversities()
            application.readFaculties()
            application.readChairs()

            application.readSchools()

            application.readSchoolsAndUniversities()
        }
    }
}

