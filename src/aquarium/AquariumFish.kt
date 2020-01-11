package aquarium

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish(), FishAction {

    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

class PlecoctomusAbstract: AquariumFish(), FishAction {

    override val color = "gold"

    override fun eat() {
        println("munch on algae")
    }
}

fun feedFish(fish: FishAction){
    // make some food then
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = PlecoctomusAbstract()

    println("Shark: ${shark.color}\nPlecoctomus: ${pleco.color}")

    feedFish(shark)
    feedFish(pleco)
}

fun main(args: Array<String>) {
    makeFish()
}