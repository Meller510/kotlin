class Player(var name: String, countTicket: Int = 1) {
    private var lotteryTickets = mutableListOf<Ticket>()

    init {
        repeat(countTicket) {
            lotteryTickets.add(takeTickets())
            lotteryTickets[it].ticketNum = it + 1
        }
    }

    private fun takeTickets(): Ticket {
        return Ticket()
    }

    fun isWin(): Boolean {
        lotteryTickets.forEach {
            if (it.lineMatch()) return true
        }
        return false
    }

    fun checkNumber(num: Number): String? {
        lotteryTickets.forEach {
            if (it.checkMatch(num)) return "Номер $num совпал у игрока $name"
        }
        return null
    }

    override fun toString(): String {
        val viewTickets = StringBuilder()
        lotteryTickets.forEach {
            if (it.ticketNum > 1) viewTickets.append("\n")
            it.ticket.forEach { i ->
                i.forEach {num ->
                    when (num) {
                        is Number.Space -> viewTickets.append(" - ")
                        is Number.Num -> viewTickets.append(" $num ")
                        else -> viewTickets.append(" x ")
                    }
                }
                viewTickets.append("\n")
            }
        }
        return "Лотерейные билеты  $name \n$viewTickets"
    }
}