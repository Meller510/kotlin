class Wheel(private var currentPressure: Double) {
    fun pumpUp(pressure: Double) {
        if (pressure < 0 || pressure > 10) throw IncorrectPressure("При накачке $pressure атмосфер процедура не удалась.")
        else currentPressure += pressure
    }

    fun checkPressureLevel(): String {
        if (currentPressure < 1.6)
            throw TooLowPressure("При накачке $currentPressure атмосфер процедура удалась. Эксплуатация невозможна — давление ниже нормального.")
        else if (currentPressure > 2.5)
            throw TooHighPressure("При накачке $currentPressure атмосфер процедура удалась. Эксплуатация невозможна — давление превышает нормальное.")
        else
            return "При накачке $currentPressure атмосферы процедура удалась. Эксплуатация возможна."
    }
}