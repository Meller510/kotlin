object Converters {
    var badCode = "UNKNOWN"
    private var convList = arrayListOf<CurrencyConverter>(USD("USD"),EUR("EUR"))
    fun get(currencyCode: String):CurrencyConverter{
        return convList.find { it.currencyCode == currencyCode.uppercase() } ?:
        object : CurrencyConverter {
            override var currencyCode = badCode
            override fun convertRub(amount: Double): Double = 0.0
        }
    }
}