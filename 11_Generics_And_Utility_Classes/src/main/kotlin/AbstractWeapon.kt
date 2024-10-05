abstract class AbstractWeapon(
    private val maxRounds: Int,
    private val fireType: FireType
) {
    private var ammoMagazine = Stack<Ammo>()
//    private var isEmpty: Boolean = true

    abstract fun createAmmo(): Ammo
    fun reloading() {
        val magazine = Stack<Ammo>()
        do magazine.push(createAmmo())
        while (magazine.size() != maxRounds)
        ammoMagazine = magazine
    }

    fun fire(): List<Ammo?> {
        val listAmmo = mutableListOf<Ammo?>()

        if (fireType is FireType.SingleShot) {
            if (ammoMagazine.isEmpty()) throw NoAmmoException()
            listAmmo.add(ammoMagazine.pop())
        } else {
            val firBurst: FireType.FiringBurst? = fireType as? FireType.FiringBurst

            if ((firBurst != null) && (ammoMagazine.size() < firBurst.queueSize)) {
                throw NoAmmoException()
            } else {
                repeat(firBurst?.queueSize!!) {
                    listAmmo.add(ammoMagazine.pop())
                }
            }
        }
        return listAmmo
    }
}