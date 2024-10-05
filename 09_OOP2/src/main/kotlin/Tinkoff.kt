class Tinkoff(balance: Float, creditLimit: Float) : CreditCard(balance, creditLimit) {
    private var cashbackSum = 5000
    private var cashbackCount: Float = 0.0f
    private var creditBalanceCount: Float = 0.0f

    override fun depositMoney(deposit: Float) {
        var curDeposit: Float = deposit

        if (creditLimit > creditBalance) {
            val debt = creditLimit - creditBalance

            if (curDeposit > debt) {
                curDeposit -= debt
                creditBalance += debt
            } else creditBalance += curDeposit

            calcCashback(deposit)
            checkUpCreditLimit(deposit)

        } else super.depositMoney(curDeposit)
    }

    override fun extendBalanceInfo() = """
        На ващем балансе суммарно : ${balance + creditBalance}
        Крединтые средства : $creditBalance
        Кредитный лимит : $creditLimit
        Собственные средства : $balance
        До начисления кешбека вам осталось пополнить кредитный счет на : ${cashbackSum - cashbackCount}
        До увеличения кредитного лимита вам осталось пополнить кредитный счет на : ${creditLimit - creditBalanceCount}
    """.trimIndent()

    private fun calcCashback(deposit: Float) {
        cashbackCount += deposit
        if (cashbackCount >= cashbackSum) {
            cashbackCount -= cashbackSum
            balance += cashbackSum * 5.0f / 100
        }
    }

    private fun checkUpCreditLimit(deposit: Float) {
        creditBalanceCount += deposit
        if (creditBalanceCount >= creditLimit) {
            creditLimit *= 1.5f
        }
    }
}