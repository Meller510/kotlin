class Sber(balance: Float) : DebitCard(balance) {
    private var bonusPoint = 0.0f

    override fun pay(requestPay: Float): Boolean {
        return if (super.pay(requestPay)) {
            if (requestPay >= 1000.0f) {
                bonusPoint += requestPay * 1.0f / 100
            }
            if (requestPay > 5000) {
                balance += requestPay * 3.0f / 100
            }
            true
        }else false
    }

    override fun extendBalanceInfo(): String = """
        Средства на карте : $balance
        Бонусные баллы : $bonusPoint
    """.trimIndent()
}