package demo.model

class CountriesList {

    var countriesCount: Int? = null
        private set

    var countries: List<Country>? = null
        set(countries) {
            field = countries
            this.countriesCount = countries!!.size
        }

    constructor() {
    }

    constructor(countries: List<Country>) {
        this.countries = countries
        this.countriesCount = countries.size
    }
}
