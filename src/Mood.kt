fun main(args: Array<String>) {
    println("Enter your mood:")
    println(whatShouldIDoToday(getUserMood()))
}

fun whatShouldIDoToday(
        mood: String,
        weather: String = "sunny",
        temperature: Int = 24
): String {
    return when {
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}

fun getUserMood() = readLine() ?: "happy"

fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

fun isVeryHot(temperature: Int) = temperature > 35