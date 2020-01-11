package aquarium

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PlecoctomusInterfaces(fishColor: FishColor = GoldColor) :
        FishAction by PrintingFishAction("a lot of algae"),
        FishColor by GoldColor

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = PlecoctomusInterfaces()
    println("Fish has has color ${pleco.color}")
    pleco.eat()
}