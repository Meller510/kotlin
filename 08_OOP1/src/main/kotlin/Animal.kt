import kotlin.random.Random

open class Animal(protected var energy: Int, protected var weight: Int, protected val maxAge: Int, val name: String) {
    private var curAge: Int = 0
    var isTooOld: Boolean = false
        private set
        get() = curAge >= maxAge

    fun sleep() {
        if (checkOfAction()) {
            println("$name спит")
            energy += 5
            curAge += 1
        }
    }

    fun eating() {
        if (checkOfAction()) {
            println("$name ест")
            energy += 3
            weight += 1
            curAge = tryIncrementAge(curAge)
        }

    }

    open fun move(): Boolean {
        if (checkOfAction()) {
            println("$name передвигается")
            energy -= 5
            weight -= 1
            curAge = tryIncrementAge(curAge)
            return true
        }
        return false
    }

   open fun birthOfChild(): Animal {
        val child = Animal(
            name = this.name,
            maxAge = this.maxAge,
            energy = (1..10).random(),
            weight = (1..5).random()
        )
        println("Родился ребенок")
        println("Имя ${child.name}")
        println("Максимальный возраст ${child.maxAge}")
        println("Энергия ${child.energy}")
        println("Вес ${child.weight}")
        return child
    }

    private fun tryIncrementAge(age: Int): Int {
        return if (Random.nextBoolean()) age + 1 else age
    }

    private fun checkOfAction(): Boolean {
        return !(isTooOld || weight <= 0 || energy <= 0)
    }
}