package aquarium

fun String.hasSpaces(): Boolean = this.find { it == ' ' } != null


open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int) : AquariumPlant(color = "Green", size = size)

fun AquariumPlant.isRed() = color == "Red"

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

//fun AquariumPlant.isBig() = size > 50 // cannot access private variable

fun extensionsExample() {
    "Does it have spaces?".hasSpaces()
    val plant = GreenLeafyPlant(size = 50)
    plant.print() // GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() // AquariumPlant

    val greenPlant = AquariumPlant(color = "Green", size = 50)
    println(greenPlant.isGreen) // true

    val nullPlant: AquariumPlant? = null
    nullPlant.pull() // ok
}

open class Shape

class Rectangle : Shape()

fun Shape.getName() = "Shape"

fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName())
}

class Example {
    fun printFunctionType() {
        println("Class method")
    }
}

fun Example.printFunctionType() {
    println("Extension function")
}

fun Example.printFunctionType(i:Int){
    println("Extension function")
}

fun main(args: Array<String>) {
//    extensionsExample()
//    printClassName(Rectangle()) // Shape
    Example().printFunctionType() // Class method
    Example().printFunctionType(1) // Extension function
}
