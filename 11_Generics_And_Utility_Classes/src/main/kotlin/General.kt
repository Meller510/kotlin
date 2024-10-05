class General(
    maxHealth: Int = 100,
    health: Int = 100,
    evasion: Int = 30,
    accuracy: Int = 98,
    weapon: AbstractWeapon = Weapons.createMachine()
) : AbstractWarrior(
    maxHealth, health, evasion,
    accuracy,
    weapon
) {
}