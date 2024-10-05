import kotlin.random.Random

fun main() {
    val firstT = Team("Зеленые", 5)
    val secondT = Team("Крассные", 5)
    val battle = Battle(firstT, secondT)
    var bState: BattleState
    while (!battle.isOver) {
        battle.iteration()
        bState = battle.state()
        println(bState.state)
    }
}

fun Int.isChance(): Boolean {
    return this >= Random.nextInt(100)
}