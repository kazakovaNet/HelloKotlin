package buildings

open class BaseBuildingMaterial(val numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(numberNeeded = 4)

class Brick : BaseBuildingMaterial(numberNeeded = 8)

class Building<T : BaseBuildingMaterial>(private val buildingMaterial: T) {

    private val baseMaterialsNeeded = 100
    private val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
    }
}

fun main() {
    Building(Wood()).build()

    Building(Brick()).build()
}