enum class Ammo(private val damage: Int, private val chanceCritDamage: Int, private val coefficientCritDamage: Int) {
    PISTOL(5, 10, 2),
    RIFLE(10, 20, 3),
    MACHINE(13, 15, 4),
    SHOTGUN(15, 25, 3);

    fun currentDamage(): Int {
        return if (chanceCritDamage.isChance()) coefficientCritDamage * damage
        else damage
    }
}
