package spice

data class SpiceContainer(val spice: Spice, val label: String = spice.name)

fun main(args: Array<String>) {
    val sc1 = SpiceContainer(Curry("Yellow Curry", "mild"))
    val sc2 = SpiceContainer(Curry("Red Curry", "medium"))
    val sc3 = SpiceContainer(Curry("Green Curry", "spicy"))
    println(sc1.label)
    println(sc2.label)
    println(sc3.label)
}