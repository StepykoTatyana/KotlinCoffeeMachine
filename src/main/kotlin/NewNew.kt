fun main() {
    println(
        "Write how many cups of coffee you will need:"
    )
    val cupsOfCoffee = readln().toInt()

    val milk = 50 * cupsOfCoffee // an integer value
    val water = 200 * cupsOfCoffee // an integer value
    val coffeeBeans = 15 * cupsOfCoffee // an integer value
    println(
        """For $cupsOfCoffee cups of coffee you will need:
$water ml of water
$milk ml of milk
$coffeeBeans g of coffee beans"""
    )

}