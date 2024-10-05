abstract class BankCard(protected var balance: Float) {

    open fun depositMoney(deposit: Float) {
        balance += deposit
    }

    open fun pay(requestPay: Float): Boolean {
        return if (requestPay <= balance) {
            balance -= requestPay
            true
        }else false
    }
    abstract fun balanceInfo(): String
    abstract fun extendBalanceInfo(): String
}