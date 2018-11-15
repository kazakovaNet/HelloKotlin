package aquarium

fun main(args: Array<String>) {
//    buildAquarium()

    fishExample()

    makeDefaultFish()
}

fun buildAquarium() {
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
