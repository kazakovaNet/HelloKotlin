package aquarium.generics

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {

    fun addChemicalCleaners() {
        needsProcessed = true
    }
}

class FishStoreWater : WaterSupply(needsProcessed = false)

class LakeWater : WaterSupply(needsProcessed = true) {

    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<T : WaterSupply>(val waterSupply: T) {

    fun addWater() {
        /**
         * Check is a standard library function in Kotlin
         * that's really convenient for checking the state of your classes.
         * It acts as an assertion and it will throw an illegal
         * exception if its argument is false.
         * Otherwise, throw an exception with the provided error message.
         */
        check(!waterSupply.needsProcessed) { "water supply needs processed" }
        println("adding water from $waterSupply")
    }
}

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

//    val aquarium2 = Aquarium("string") // does not work
//    print(aquarium2.waterSupply)

//    val aquarium3 = Aquarium(null) // does not work
//    aquarium3.waterSupply

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
}

fun main() {
    genericExample()
}