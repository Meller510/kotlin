sealed class BattleState {
    val state: String
        get() = when (this) {
            is Progress -> progress
            is Team1 -> "\nКоманда ${team.name} победила!!"
            is Team2 -> "\nКоманда ${team.name} победила!!"
            is Draw -> "\nНичья"
        }

    class Progress(team: Team, team2: Team) : BattleState() {
        val progress: String =
            "\n${team.name} : осталось солдат = ${team.getWarriors().size}  " +
                    "суммарное здоровье команды = ${team.getWarriors().sumOf { it.health }}" +
                    "\n${team2.name} : осталось солдат = ${team2.getWarriors().size}  " +
                    "суммарное здоровье команды = ${+team2.getWarriors().sumOf { it.health }}"
    }

    class Team1(val team: Team) : BattleState()
    class Team2(val team: Team) : BattleState()
    object Draw : BattleState()
}