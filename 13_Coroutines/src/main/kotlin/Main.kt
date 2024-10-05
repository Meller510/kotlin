import kotlinx.coroutines.*
import java.math.BigInteger

suspend fun main() {
    runBlocking {
        val calc1 = async {
            try {
                withTimeout(2000) {
                    Fibonacci.take(200000)
                }
            } catch (t: TimeoutCancellationException) {
                println("Вычисление слишком долгое!")
            }
        }

        val calc2 = async {
            try {
                withTimeout(2000) {
                    Fibonacci.take(10)
                }
            } catch (t: TimeoutCancellationException) {
                println("Вычисление слишком долгое!")
            }
        }

        launch {
            var i = 1
            while (calc1.isActive || calc2.isActive) {
                delay(5)
                if (i % 10 == 0) println(".")
                else print(".")
                i++

            }
        }

        println("Начало вычислений")
        print("\nПервое число = ${calc1.await()} \nВторое число = ${calc2.await()}")
    }
}

object Fibonacci {
    suspend fun take(index: Int): BigInteger {
        var n0 = BigInteger.ZERO
        var n1 = BigInteger.ONE
        var i = BigInteger.TWO

        while (i <= index.toBigInteger()) {
            yield()
            val n2 = n0.add(n1)
            n0 = n1
            n1 = n2
            i++
        }

        return n1
    }
}


