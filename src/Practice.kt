import java.util.*

fun main(args: Array<String>) {
//    var fortune = ""

    /**
     * var 1.
     */
//    repeat(10) {
//        fortune = getFortune(getBirthday())
//
//        println("\nYour fortune is: $fortune")
//
//        if (fortune.contains("Take it easy")) return
//    }

    /**
     * var 2.
     */
//    while (!fortune.contains("Take it easy")) {
//        fortune = getFortune(getBirthday())
//
//        println("\nYour fortune is: $fortune")
//    }

//    println(canAddFish(10.0, listOf(3, 3, 3)))
//    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
//    println(canAddFish(9.0, listOf(1, 1, 3), 3))
//    println(canAddFish(10.0, listOf(), 7, true))

    gamePlay(rollDice3(4))
    gamePlay(rollDice3(0))
}

fun gamePlay(diceRoll: Int) {
    println(diceRoll)
}

fun canAddFish(
        tankSize: Double,
        currentFish: List<Int>,
        fishSize: Int = 2,
        hasDecorations: Boolean = true
): Boolean {
//    var commonLength = 0;
//    if (currentFish.isNotEmpty()) {
//        for (fishLength in currentFish) {
//            commonLength += fishLength
//        }
//    }
//
//    if (hasDecorations) {
//        if (commonLength + fishSize > tankSize.times(.8)) {
//            return false
//        }
//    } else {
//        if (commonLength + fishSize > tankSize) {
//            return false
//        }
//    }
//
//    return true

    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun getBirthday(): Int {
    print("Enter your birthday: ")

    return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    return when (birthday) {
        in 1..7 -> fortunes[0]
        in 8..14 -> fortunes[1]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

private fun greetingKotlin(args: Array<String>) {
    println(when (args[0].toInt()) {
        in 0..12 -> "Good morning, Kotlin"
        else -> "Good night, Kotlin"
    })

    println("Good ${if (args[0].toInt() < 12) "morning" else "night"}, Kotlin")
}

fun dayOfWeek() {
    println("What day is it today?")

    val dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    when (dayOfWeek) {
        0 -> println("Sunday")
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        6 -> println("Saturday")
    }

}

val rollDice = { Random().nextInt(12) + 1 }

val rollDice2 = { sides: Int -> Random().nextInt(sides) + 1 }

val rollDice0 = { sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

val rollDice3: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

