object Weapons {
    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon(7, FireType.SingleShot) {
            override fun createAmmo() = Ammo.PISTOL
        }
    }

    fun createRifle(): AbstractWeapon {
        return object : AbstractWeapon(12, FireType.SingleShot) {
            override fun createAmmo() = Ammo.RIFLE
        }
    }

    fun createMachine(): AbstractWeapon {
        return object : AbstractWeapon(20, FireType.FiringBurst(3)) {
            override fun createAmmo() = Ammo.MACHINE
        }
    }

    fun createShotGun(): AbstractWeapon {
        return object : AbstractWeapon(25, FireType.SingleShot) {
            override fun createAmmo() = Ammo.SHOTGUN
        }
    }
}