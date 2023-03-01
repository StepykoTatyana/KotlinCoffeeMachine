fun main() {
    println("Write how many ml of water the coffee machine has:")
    val waterForUser = readln().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milkForUser = readln().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeansForUser = readln().toInt()
    println("Write how many cups of coffee you will need:")
    val cupsForUser = readln().toInt()


    val milkForOne = 50 // an integer value
    val waterForOne = 200 // an integer value
    val coffeeBeansForOne = 15 // an integer value

    var minimum: Int
    val waterNeeded = waterForUser / waterForOne
    val milkNeeded = milkForUser / milkForOne
    val coffeeNeeded = coffeeBeansForUser / coffeeBeansForOne
    if (waterNeeded <= milkNeeded && waterNeeded <= coffeeNeeded) {
        minimum = waterNeeded
    } else if (coffeeNeeded < waterNeeded && coffeeNeeded <= milkNeeded) {
        minimum = coffeeNeeded
    } else {
        minimum = milkNeeded
    }

    if (minimum < cupsForUser) {
        println("No, I can make only $minimum cups of coffee")
    }
    if (minimum == cupsForUser) {
        println("Yes, I can make that amount of coffee")
    }
    if (minimum > cupsForUser) {
        val difference = minimum - cupsForUser
        println("Yes, I can make that amount of coffee (and even $difference more than that)")
    }
}