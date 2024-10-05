class Team(val name: String, count: Int) {
    private var warriors = mutableListOf<AbstractWarrior>()

    fun getWarriors(): List<AbstractWarrior> {
        warriors.removeIf { it.isKilled }
        return warriors
    }

    fun remove(element: AbstractWarrior): Boolean {
        return warriors.remove(element)
    }

    fun isAlive(): Boolean {
        return warriors.isNotEmpty()
    }

    init {
        repeat(count) {
            if (25.isChance()) warriors.add(General())
            else if (35.isChance()) warriors.add(Captain())
            else warriors.add(Soldier())
        }
    }
}