class Ticket {
    var ticketNum = 0
    val ticket = Array(3) {
        MutableList<Number>(10) { Number.Space() }
    }

    init {
        val numbersStack = ArrayDeque((1..90).toList().shuffled())
        for (i in ticket.indices) {
            val cells = (0..9).toList().shuffled()
            for (j in 0..4) {
                ticket[i][cells[j]] = Number.Num(numbersStack.removeLast())
            }
        }
    }

    fun lineMatch(): Boolean {
        ticket.forEach {
            return it.count { i -> i is Number.AccessNum } == 5
        }
        return false
    }

    fun checkMatch(num: Number): Boolean {
        for (i in ticket.indices) {
            for (j in 0 until ticket[i].size) {
                if (ticket[i][j].num == num.num) {
                    ticket[i][j] = Number.AccessNum(num)
                    return true
                }
            }
        }
        return false
    }
}