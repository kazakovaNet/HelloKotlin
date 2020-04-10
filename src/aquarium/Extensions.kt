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

fun Example.printFunctionType(i: Int) {
    println("Extension function")
}

/**
 * Note that extensions can be defined with nullable
 * receiver type. Such extensions can be called on
 * object variable even if its value in null, and
 * can check for 'this == null' inside the body.
 */
fun nullCheck(): String {
    fun MutableList<Int>?.getFirst(): String {
        if (this == null) return "list is null"

        return this[0].toString()
    }

    val list = mutableListOf<Int>(1, 2, 3)
    val list2 = null

    return "list first item = ${list.getFirst()}\n" +
            "list2 first item = ${list2.getFirst()}"
}

/**
 * Similarly to functions, Kotlin supports extension
 * properties. Note that, since extensions do not
 * actually insert members into classes, there's
 * no efficient way for an extension property to
 * have a backing field. This is why initializers
 * are not allowed for extension properties.
 * Their behavior can only be defined by explicitly
 * providing getters/setters.
 */
val MutableList<Int>.hasTwo: Boolean
    get() = this.contains(2)

var MutableList<Int>.first: Int
    get() = this[0]
    set(value) {
        this[0] = value
    }

fun properties(): String {
    val list = mutableListOf<Int>(1, 2, 3)
    var list2 = mutableListOf<Int>(6, 7, 3)

    var string: String = "list : ${list.toString()}\n" +
            "list2 : ${list2.toString()}\n\n" +
            "list has 2 = ${list.hasTwo}\n" +
            "list2 has 2 = ${list2.hasTwo}\n\n" +
            "list[0] set to 9\n"

    list.first = 9

    string += "list[0] : ${list.first}"

    return string
}

/**
 * Inside a class, you can declare extensions for
 * another class. Inside such an extension, there
 * are multiple implicit receivers-objects members
 * of which can be accessed without a qualifier.
 * The instance of the class in which the extension
 * is declared is called dispatch receiver, and the
 * instance of the receiver type of the extension method
 * is called extension receiver.
 */
fun members(): String {
    class D {
        fun bar(): String {
            return "bar in D()\n"
        }
    }

    class C {
        fun baz(): String {
            return "baz in C()\n"
        }

        fun D.foo(): String {
            return "in D.foo()\n" +
                    "bar() from D.bar() : ${bar()}\n" +
                    "baz() from C.Baz() : ${baz()}"
        }

        fun caller(d: D): String {
            return d.foo() // calling the extension function
        }
    }

    var string = C().caller(D())

    /**
     * In case of name conflict between the members
     * of the dispatch receiver and the extension receiver
     * the extension receiver takes precendence. To refer
     * to the member of the dispatch receiver you can use the
     * qualified 'this' syntax
     */

    class E {
        fun bar(): String {
            return "bar() in E"
        }
    }

    class F {
        fun bar(): String {
            return "bar() in F"
        }

        fun E.foo(): String {
            return "bar from E : ${bar()}\n" +
                    "bar from F : ${this@F.bar()}"
        }

        fun caller(e: E): String {
            return e.foo() // calling the extension
        }
    }

    string += F().caller(E())

    /**
     * Extensions declared as members can be declared
     * as open and overridden in subclasses. THis means
     * that the dispatch of such functions is virtual
     * with regard to the dispatch receiver type,
     * but static with regard to the extension receiver type
     */
    open class G

    class G1 : G()

    open class H {
        open fun G.foo(): String {
            return "G.foo in H"
        }

        open fun G1.foo(): String {
            return "G1.foo in H"
        }

        fun caller(g: G): String {
            return g.foo() // call the extension function
        }
    }

    class H1 : H() {
        override fun G.foo(): String {
            return "G.foo in H1"
        }

        override fun G1.foo(): String {
            return "G1.foo in H1"
        }
    }

    string += "${H().caller(G())}\n" +
            "${H1().caller(G())}\n" + // dispatch received is resolved virtually
            "${H().caller(G1())}" // extension receiver is resolved statically

    return string
}

fun main(args: Array<String>) {
//    extensionsExample()
//    printClassName(Rectangle()) // Shape
//    Example().printFunctionType() // Class method
//    Example().printFunctionType(1) // Extension function
//    print(nullCheck())
//    print(properties())
    print(members())
}
