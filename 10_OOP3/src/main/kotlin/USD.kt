class USD(override var currencyCode: String) : CurrencyConverter  {
    override fun convertRub(amount: Double): Double {
        val rateUSD = 0.013
        return  amount * rateUSD
    }

}