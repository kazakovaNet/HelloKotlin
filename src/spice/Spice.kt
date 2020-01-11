package spice

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }

    init {
        println("constructed spice name $name, spiciness $spiciness, heat $heat")
    }

    override fun toString() = "Spice name: $name, spiciness: $spiciness, heat: $heat\n"

    abstract fun prepareSpice()
}

class Curry(name: String,
            spiciness: String,
            color: SpiceColor = YellowSpiceColor) : Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
        println("Curry was gridded")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "yellow"
}

//fun makeSalt() = Spice("salt")

fun main(args: Array<String>) {
//    val spices = listOf(
//            Spice("curry", "mild"),
//            Spice("pepper", "medium"),
//            Spice("cayenne", "spicy"),
//            Spice("ginger", "mild"),
//            Spice("red curry", "medium"),
//            Spice("green curry", "mild"),
//            Spice("hot pepper", "extremely spicy")
//    )
//
//    val spice = 5
//
//    val filteredSpices = spices.filter { it.heat < spice }
//    println("$filteredSpices\n")
//
//    makeSalt()
    val curry = Curry("curry", "mild")
    println("Spice name: ${curry.name}, color: ${curry.color}, spiciness: ${curry.spiciness}")
}

