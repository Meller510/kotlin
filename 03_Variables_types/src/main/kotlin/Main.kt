fun main(args: Array<String>) {
    val firstName = "Vadim"
    val lastName = "Erler"
    val weight = 86.6f
    var height = 1.86
    var isChild =  height < 1.50 || weight < 40
    var info = "firstName -> $firstName\n" +
            "lastName -> $lastName\n" +
            "height -> $height\n" +
            "weight -> $weight\n" +
            "isChild -> $isChild\n\n"

    println(info)

    height = 1.40
    isChild =  height < 1.50 || weight < 40
    info = "firstName -> $firstName\n" +
            "lastName -> $lastName\n" +
            "height -> $height\n" +
            "weight -> $weight\n" +
            "isChild -> $isChild"

    println(info)
}