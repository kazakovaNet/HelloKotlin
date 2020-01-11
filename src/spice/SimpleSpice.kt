package spice

class SimpleSpice {
    val name = "curry"
    val spiciness = "mild"
    val heat: Int
        get() = 5
}

fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} ${simpleSpice.heat}\n")
}