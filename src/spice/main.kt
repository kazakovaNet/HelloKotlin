package spice

fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} ${simpleSpice.heat}\n")

    val spices = listOf(
            Spice("curry", "mild"),
            Spice("pepper", "medium"),
            Spice("cayenne", "spicy"),
            Spice("ginger", "mild"),
            Spice("red curry", "medium"),
            Spice("green curry", "mild"),
            Spice("hot pepper", "extremely spicy")
    )

    val spice = 5

    val filteredSpices = spices.filter { it.heat < spice }
    println("$filteredSpices\n")

    makeSalt()
}

fun makeSalt() = Spice("salt")