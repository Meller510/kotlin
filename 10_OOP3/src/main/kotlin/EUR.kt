class EUR(override var currencyCode: String) : CurrencyConverter {
    override fun convertRub(amount: Double): Double {
        val rateEUR = 0.012
        return amount * rateEUR
    }
}