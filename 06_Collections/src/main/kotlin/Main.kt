import java.math.BigInteger

fun main(args: Array<String>) {
    print("Введите количество добавляемых телефонных номеров : ")
    val count = inputNumber()
    val phoneNumbers = createListPhoneNum(count)

    println("\nНомера телефонов, начинающиеся с приставки +7:")
    phoneNumbers.filter { it.startsWith("+7") }.forEach { println(it) }

    val uniquePNumber = phoneNumbers.toSet()
    println("\nКоличество уникальных введённых номеров : ${uniquePNumber.size}")

    println("\nСумма длин всех номеров телефонов : ${phoneNumbers.sumOf { it.length }}\n")

    val phoneBook = addNameOfPhoneNumbers(uniquePNumber)
    println("")
    phoneBook.forEach {
        println("Абонент: ${it.value}. Номер телефона : ${it.key}")
    }

    println("\nСписок номеров отсортированный по номерам телефона :")
    phoneBook.entries.sortedBy { it.key }.forEach {
        println("Абонент: ${it.value}. Номер телефона : ${it.key}")
    }

    println("\nСписок номеров отсортированный по имени :")
    phoneBook.entries.sortedBy { it.value }.forEach {
        println("Абонент: ${it.value}. Номер телефона : ${it.key}")
    }
}

fun inputNumber(): Int {
    var num: Int? = null

    while (num == null) {
        num = readlnOrNull()?.toIntOrNull()
        if ((num == null) || (num <= 0)) {
            num = null
            println("Неверный ввод!")
        }
    }
    return num
}

fun inputPhoneNumber(): String {
    var phone: String? = null

    while (phone == null) {
        print("Введите номер телефона : ")
        phone = readlnOrNull()

        if ((phone!!.removePrefix("+").toBigIntegerOrNull() == null) || (phone.toBigInteger() < BigInteger.ZERO)) {
            phone = null
            println("Неверный ввод!")
        }
    }
    return phone
}

fun createListPhoneNum(count: Int): List<String> {
    val phoneNumbers = mutableListOf<String>()

    for (i in 1..count) {
        val phoneNum = inputPhoneNumber()
        phoneNumbers.add(phoneNum)
    }
    return phoneNumbers
}

fun addNameOfPhoneNumbers(pNumbers: Set<String>): Map<String, String> {
    val phoneBook = mutableMapOf<String, String>()

    for (i in pNumbers) {
        print("Введите имя человека с номером телефона $i : ")
        val name = readlnOrNull()
        phoneBook[i] = name!!
    }
    return phoneBook
}
