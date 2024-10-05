fun main(args: Array<String>) {
    val text = "F2p)v\"y233{0->c}ttelciFc"
    val msgFirstPart = decryptFirstPartMsg(text)
    val msgSecondPart = decryptSecondPartMsg(text)
    val msgDecrypted = msgFirstPart + msgSecondPart
    print(msgDecrypted)
}

fun decryptFirstPartMsg(msg : String): String {
    var firstPart = msg.take(msg.length / 2)

//    firstPart = firstPart.map {char -> char + 1}.joinToString("")

    firstPart = shift(firstPart){it + 1}
    firstPart = firstPart.replace("5","s")
    firstPart = firstPart.replace("4","u")

//    firstPart = firstPart.map { char -> char - 3 }.joinToString("")

    firstPart = shift(firstPart){it - 3}
    firstPart = firstPart.replace("0","o")

    return firstPart
}

fun decryptSecondPartMsg(msg : String): String {
    var secondPart = msg.takeLast(msg.length / 2)
    secondPart = secondPart.reversed()

//    secondPart = secondPart.map { char -> char - 4 }.joinToString("")

    secondPart = shift(secondPart){it - 4}
    secondPart = secondPart.replace("_", " ")

    return secondPart
}

fun shift(text: String, func: (Char) -> Char): String {
    return text.map(func).joinToString("")
}