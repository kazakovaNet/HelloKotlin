package spice

class Spice(val name: String, val spiciness: String = "mild") {
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
}