abstract class CreditCard(balance: Float, protected var creditLimit: Float) : BankCard(balance) {
    protected var creditBalance: Float = creditLimit

    override fun pay(requestPay: Float): Boolean {
        var curPay = requestPay

        return if(super.pay(curPay)) true
        else {
            if (balance > 0) {
                curPay -= balance
                balance = 0.0f
            }
            if (creditBalance > 0 && creditBalance > curPay) {
                creditBalance -= curPay
                true
            } else false
        }
    }

    override fun balanceInfo() = """
        На ващем балансе суммарно : ${balance+creditBalance}
        Крединтые средства : $creditBalance
        Собственные средства : $balance
        """.trimIndent()

}