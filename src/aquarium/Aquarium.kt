package aquarium

import kotlin.math.PI

fun main(args: Array<String>) {
    val fish = Fish()

    val (tool, use) = giveMeATool()

    println("The $tool is a tool for $use")
}

fun giveMeATool(): Pair<String, String>{
    val equipment = "fishnet" to "catching fish" to "of big size" to "and strong"

    val equip = ("fishnet" to "catching fish") to ("of big size" to "and strong")

    println(equip.toString())
    println(equipment.toList())

    return "fishnet" to "catching fish"
}

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {

        val water = numberOfFish * 2000 // cm3
        val tank = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}

internal fun buildAquarium() = Aquarium()

class TowerTank(): Aquarium() {

    override var water = volume * 0.8

    override var volume:Int
        get() = (width * height * length / 1000* PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}