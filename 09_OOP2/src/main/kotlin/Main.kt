fun main() {
    val tinkoff = Tinkoff(1000.0f, 5000.0f)
    println(
        """Здравствуйте вы получили кредитную карту Тинькофф
            |У нас дейсвуют специальные предложения!
            |При пополнении кредитного баланса на 5 тысяч вы получаете кэшбэк 5% на основной счет.
            |При пополнении кредитного счета на сумму кредитного лимита мы увеличивает ваш лимит в полтора раза.
        """.trimMargin()
    )
    println()
    println(tinkoff.balanceInfo())
    println()
    println("Выполняется отлата на сумму 3000")
    checkPay(tinkoff.pay(3000.0f))
    println()
    println("Выполняется отлата на сумму 4000")
    checkPay(tinkoff.pay(4000.0f))
    println()
    println("Выполнятся пополнение на сумму 5000")
    tinkoff.depositMoney(5000.0f)
    println()
    println("Выполнятся пополнение на сумму 5000")
    tinkoff.depositMoney(5000.0f)
    println()
    println("Выполняется отлата на сумму 3000")
    checkPay(tinkoff.pay(5000.0f))
    println()
    println(tinkoff.extendBalanceInfo())
    println()
    println("Выполнятся пополнение на сумму 5000")
    tinkoff.depositMoney(5000.0f)
    println()
    println(tinkoff.extendBalanceInfo())
    println("\n\n")

    val sber = Sber(3000.0f)
    println(
        """
            Здравствуйте вы получили дебетовую карту СБЕР
            У нас дейсвуют специальные предложения!
            При оплате на 1000 и выше вы получаете баллы в размере 1% от покупок. Баллы вы можете реализовать в нашем специальном магазине предложений. 
            При оплате на сумму больше 5000 вы получаете кешбэк 3%.
        """.trimIndent()
    )
    println()
    println(sber.balanceInfo())
    println()
    println("Выполняется отлата на сумму 3000")
    checkPay(sber.pay(3000.0f))
    println()
    println("Выполнятся пополнение на сумму 7000")
    sber.depositMoney(7000.0f)
    println()
    println("Выполняется отлата на сумму 6000")
    checkPay(sber.pay(6000.0f))
    println()
    println("Выполняется отлата на сумму 6000")
    checkPay(sber.pay(6000.0f))
    println()
    println(sber.extendBalanceInfo())
    println()
}

fun checkPay(check: Boolean) {
    if (check) println("Оплата прошла успешно")
    else println("Недостаточно средств")
}