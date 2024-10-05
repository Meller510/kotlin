fun main() {
    println("Введите в какю валюту вы хотите перевести рубли, USD-доллары EUR-евро")
    val converts = Converters
    var converter : CurrencyConverter? = null

    var codeLike = true
    while (codeLike){
        val code = readln()
        converter = converts.get(code)
        if (converter.currencyCode != Converters.badCode) codeLike = false
        else println("У нас нет возможноти перевода в такую валюту. Попробуйте еще раз!")
    }

    println("Введите сумму в рублях для обмена в ${converter?.currencyCode}")
    val rub = readlnOrNull()?.toDouble()!!
    val amount = converter?.convertRub(rub)

    println("$rub рублей = $amount ${converter?.currencyCode}")
}