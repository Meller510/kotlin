interface Warrior {
    var isKilled: Boolean
    var evasion: Int
    fun attack(enemy: Warrior)
    fun takeDamage(damage: Int)
}