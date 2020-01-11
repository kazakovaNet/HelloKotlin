package aquarium

fun main(args: Array<String>) {
//    buildAquariumTest()

//    fishExample()

//    makeDefaultFish()

    val testList = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    println(reverseList(testList))
    println(reverseListAgain(testList))
    println(testList.reversed())

    symptoms()

    testMap()
}

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.indices) {
        result.add(list[list.size - i - 1])
    }
    return result
}

fun symptoms() {
    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")

    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red") // false
    symptoms.contains("red spots") // true

    println(symptoms.subList(4, symptoms.size)) // [belly up]

    listOf(1, 5, 3).sum() // 9

    listOf("a", "b", "cc").sumBy { it.length } // 4
}

fun testMap() {
    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    println(cures.getOrDefault("bloating", "sorry I don't know"))
    println(cures.getOrElse("bloating") { "No cure for this" })

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")
}

fun reverseListAgain(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}

fun buildAquariumTest() {
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length} Width: ${myAquarium.width} Height: ${myAquarium.height}\n")

    myAquarium.height = 80

    println("Heigth: ${myAquarium.height} cm")
    println("Volume: ${myAquarium.volume} liters\n")

    myAquarium.volume = 150

    println("Volume: ${myAquarium.volume} liters")
    println("Length: ${myAquarium.length} Width: ${myAquarium.width} Height: ${myAquarium.height}\n")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)
    println("Small aquarium: ${smallAquarium.volume} liters\n")

    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("Small aquarium 2: ${myAquarium2.volume} liters with length ${myAquarium2.length} width: ${myAquarium2.width} height: ${myAquarium2.height}\n")

}
