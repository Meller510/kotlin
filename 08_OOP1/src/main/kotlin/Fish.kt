class Fish(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(energy, weight, maxAge, name) {
    override fun move(): Boolean {
        if (super.move()) {
            println("Тип передвижения : плывет")
            return true
        }
        return false
    }

    override fun birthOfChild(): Fish {
        val child = Fish(
            name = this.name, maxAge = this.maxAge,
            energy = (1..10).random(), weight = (1..5).random()
        )
        println("Родился ребенок")
        println("Имя ${child.name}")
        println("Максимальный возраст ${child.maxAge}")
        println("Энергия ${child.energy}")
        println("Вес ${child.weight}")
        return child
    }
}