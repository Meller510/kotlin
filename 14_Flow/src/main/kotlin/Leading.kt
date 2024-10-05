

class Leading {
     val numbersStack = ArrayDeque((1..90).toList().shuffled())

    fun getNumber(): Number {
        val num = numbersStack.removeLastOrNull()
        numbersStack.shuffled()
        return if (num != null) Number.Num(num)
        else Number.Space()
    }
}