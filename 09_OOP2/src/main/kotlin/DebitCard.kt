abstract class DebitCard(balance: Float) : BankCard(balance) {
    override fun balanceInfo(): String ="Средства на карте : $balance"
}