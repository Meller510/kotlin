class NatureReserve(numFish: Int, numDog: Int, numBird: Int, numAnimal: Int, private val numIterations: Int) {
    private var animalsList = mutableListOf<Animal>()

    init {
        val fishes = mutableListOf<Fish>()
        val dogs = mutableListOf<Dog>()
        val birds = mutableListOf<Bird>()
        val animals = mutableListOf<Animal>()

        val maxNum = maxOf(numFish, numDog, numBird, numAnimal)
        for (i in 0..maxNum) {
            if (i < numFish) {
                fishes.add(
                    Fish(
                        energy = (1..10).random(), weight = (1..5).random(),
                        maxAge = (6..11).random(), name = "Рыбёха"
                    )
                )
            }
            if (i < numDog) {
                dogs.add(
                    Dog(
                        energy = (1..10).random(), weight = (1..5).random(),
                        maxAge = (6..15).random(), name = "Собакен"
                    )
                )
            }

            if (i < numBird) {
                birds.add(
                    Bird(
                        energy = (1..10).random(), weight = (1..5).random(),
                        maxAge = (3..10).random(), name = "Птичка"
                    )
                )
            }

            if (i < numAnimal) {
                animals.add(
                    Animal(
                        energy = (1..10).random(), weight = (1..5).random(),
                        maxAge = (1..10).random(), name = "Животное"
                    )
                )
            }
        }
        animalsList = animalsList.asSequence().plus(birds).plus(fishes).plus(dogs).plus(animals).toMutableList()
    }

    fun lifeCycle() {
        for (i in 0..numIterations) {
            println("ВНИМАНИЕ НОВЫЙ ЦИКЛ --> ${i+1}")
            val child = mutableListOf<Animal>()
            animalsList.forEach {
                println("Действие ${it.name}")
                when ((1..4).random()) {
                    1 -> it.eating()
                    2 -> it.sleep()
                    3 -> it.move()
                    4 -> child.add(it.birthOfChild())
                }
                println("Действие ${it.name} законченно\n")
            }
            animalsList.removeIf { it.isTooOld }
            if (child.isNotEmpty()) animalsList = animalsList.plus(child).toMutableList()
            if (animalsList.isEmpty()) {
                println("Все животные погибли")
                break
            }
        }
        if (animalsList.isNotEmpty()) println("Число живых животных --> ${animalsList.size}")
    }
}