fun main() {
    val wheel = Wheel(0.5)

    try {
        println(wheel.checkPressureLevel())
    } catch (t: TooLowPressure) {
        println(t.message)
    } catch (t: TooHighPressure) {
        println(t.message)
    }

    try {
        wheel.pumpUp(1.3)
        println(wheel.checkPressureLevel())
    } catch (t: TooLowPressure) {
        println(t.message)
    } catch (t: TooHighPressure) {
        println(t.message)
    }

    try {
        wheel.pumpUp(-1.4)
        println(wheel.checkPressureLevel())
    } catch (t: IncorrectPressure) {
        println(t.message)
    }

    try {
        wheel.pumpUp(4.3)
        println(wheel.checkPressureLevel())
    } catch (t: TooLowPressure) {
        println(t.message)
    } catch (t: TooHighPressure) {
        println(t.message)
    }

}

class TooLowPressure(s: String) : Throwable(s)
class TooHighPressure(s: String) : Throwable(s)
class IncorrectPressure(s: String) : Throwable(s)