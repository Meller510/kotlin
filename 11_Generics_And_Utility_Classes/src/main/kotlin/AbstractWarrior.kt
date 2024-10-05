abstract class AbstractWarrior(
    var maxHealth: Int,
    var health: Int,
    override var evasion: Int,
    private var accuracy: Int,
    private var weapon: AbstractWeapon
) : Warrior {
    init {
        weapon.reloading()
    }

    override var isKilled: Boolean = health <= 0

    override fun takeDamage(damage: Int) {
        if (health - damage > 0) health -= damage
        else {
            isKilled = true
            health = 0
        }
    }

    override fun attack(enemy: Warrior) {
        try {
            weapon.fire().forEach {
                if (!enemy.evasion.isChance() && accuracy.isChance()) {
                    if (it != null) {
                        enemy.takeDamage(it.currentDamage())
                    }
                }
            }
        } catch (_: NoAmmoException) {
            weapon.reloading()
        }
    }
}

