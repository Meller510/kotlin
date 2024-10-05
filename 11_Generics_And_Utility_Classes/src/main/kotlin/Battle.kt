class Battle(fTeam: Team, sTeam: Team) {
    var firstTeam = fTeam
    var secondTeam = sTeam
    var isOver: Boolean = false

    fun state(): BattleState {
        return if (firstTeam.isAlive() && secondTeam.isAlive()) BattleState.Progress(firstTeam, secondTeam)
        else if (firstTeam.isAlive() && !secondTeam.isAlive()) BattleState.Team1(firstTeam)
        else if (!firstTeam.isAlive() && secondTeam.isAlive()) BattleState.Team2(secondTeam)
        else BattleState.Draw
    }

    fun iteration() {
        if (!isOver) {
            val secWar = secondTeam.getWarriors().random()
            val firWar = firstTeam.getWarriors().random()

            if (firstTeam.isAlive()) firstTeam.getWarriors().random().attack(secWar)
            if (secWar.isKilled) secondTeam.remove(secWar)

            if (secondTeam.isAlive()) secondTeam.getWarriors().random().attack(firWar)
            if (firWar.isKilled) firstTeam.remove(firWar)

            if (!secondTeam.isAlive() || !firstTeam.isAlive()) isOver = true
        }
    }
}