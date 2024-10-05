class Soldier(
    maxHealth: Int = 70,
    health: Int = 70,
    evasion: Int = 10,
    accuracy: Int = 80,
    weapon: AbstractWeapon = Weapons.createPistol(),
) : AbstractWarrior(
    maxHealth, health, evasion,
    accuracy,
    weapon
) {
    init {
        weapon.reloading()
    }
}