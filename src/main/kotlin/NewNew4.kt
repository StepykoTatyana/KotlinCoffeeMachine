var water = 400
var milk = 540
var coffee_beans = 120
var cups = 9
var money = 550

fun main() {
    take()
    println("\nWrite action (buy, fill, take):")
    when (readln()) {
        "buy" -> {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
            when (readln().toInt()) {
                1 -> {
                    buy(250, 0, 16, 4)
                }

                2 -> {
                    buy(350, 75, 20, 7)
                }

                3 -> {
                    buy(200, 100, 12, 6)
                }

            }
        }

        "fill" -> feel()
        "take" -> {
            println("I gave you $$money")
            money = 0
            println()
            take()
        }
    }
}

fun feel() {
    println("Write how many ml of water do you want to add:")
    water = 400 + readln().toInt()
    println("Write how many ml of milk do you want to add:")
    milk = 540 + readln().toInt()


    println("Write how many grams of coffee beans do you want to add:")
    coffee_beans = 120 + readln().toInt()

    println("Write how many disposable cups of coffee do you want to add:")
    cups = 9 + readln().toInt()
    println()
    take()
}


fun take() {
    println(
        """The coffee machine has: 
$water of water
$milk of milk
$coffee_beans of coffee beans
$cups of disposable cups 
$$money of money"""
    )
}


fun buy(
    waterForCoffee: Int,
    milkForCoffee: Int,
    coffeeBeansForCoffee: Int,
    moneyForCoffee: Int
) {
    water -= waterForCoffee
    milk -= milkForCoffee
    coffee_beans -= coffeeBeansForCoffee
    cups -= 1
    money += moneyForCoffee
    println()
    take()
}
