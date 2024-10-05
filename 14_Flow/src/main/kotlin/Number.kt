sealed class Number( val num: Int) {
    class Num(num: Int) : Number(num)
    class AccessNum(num: Number) : Number(num.num)
    class Space : Number(-1)

    override fun toString(): String {
        return num.toString()
    }
}