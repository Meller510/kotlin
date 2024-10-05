import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow

class Lotto(private vararg val players: Player) {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val leading = Leading()
    private val generator = MutableSharedFlow<Number>(leading.numbersStack.size)

    private fun checkWin(): Boolean {
        return players.any { it.isWin() }
    }

    private fun getWinner(): String {
        val player = players.find { it.isWin() }
        return if (player != null) "ПоБедил ${player.name}"
        else "Победителей нет"
    }

    private suspend fun setGeneratorNumbers() {
        scope.launch {
            var num: Number
            while (true) {
                num = leading.getNumber()
                if (num == Number.Space()) break
                generator.emit(num)
                yield()
            }
        }
    }

    private suspend fun gameLoop() {
        val jobs = mutableListOf<Job>()
        players.forEach { player ->
            jobs.add(
                scope.launch {
                    println("создание корутины ${player.name}")
                    generator.collect { num ->
                        val str = player.checkNumber(num)
                        if (!str.isNullOrEmpty()) println(str)
                        if (num == Number.Space() || checkWin()) scope.cancel()
                    }
                })
        }
        jobs.forEach { it.join() }
    }

    fun play() {
        runBlocking {
            setGeneratorNumbers()
            gameLoop()
        }
        println()
        println(getWinner())
    }
}