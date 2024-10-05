interface CurrencyConverter {
    var currencyCode: String
    fun convertRub(amount : Double) : Double
}