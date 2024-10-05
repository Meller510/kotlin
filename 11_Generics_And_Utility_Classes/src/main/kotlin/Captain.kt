class Captain(
    maxHealth: Int = 80,
    health: Int = 80,
    evasion: Int = 20,
    accuracy: Int = 90,
    weapon: AbstractWeapon = Weapons.createRifle(),
) : AbstractWarrior(
    maxHealth, health, evasion,
    accuracy,
    weapon
) {
}