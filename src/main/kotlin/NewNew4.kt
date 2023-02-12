import java.lang.Exception

var water = 400
var milk = 540
var coffee_beans = 120
var cups = 9
var money = 550
var lack = ""

fun main() {
    //take()
    while (true) {

        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> {
                println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
                when (readln().toIntOrNull()) {
                    1 -> {
                        buy(250, 0, 16, 4)
                    }

                    2 -> {
                        buy(350, 75, 20, 7)
                    }

                    3 -> {
                        buy(200, 100, 12, 6)
                    }

                    null -> {
                        println()
                        continue
                    }


                }
            }

            "fill" -> feel()
            "take" -> {
                println("I gave you $$money")
                money = 0
                println()
//                take()
            }

            "remaining" -> {
                println()
                take()
                println()
            }

            "exit" -> {
                break
            }
        }
    }

}

fun feel() {
    println()
    println("Write how many ml of water do you want to add:")
    water += readln().toInt()
    println("Write how many ml of milk do you want to add:")
    milk += readln().toInt()


    println("Write how many grams of coffee beans do you want to add:")
    coffee_beans += readln().toInt()

    println("Write how many disposable cups of coffee do you want to add:")
    cups += readln().toInt()
    println()
//    take()
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


    if (water >= waterForCoffee && coffee_beans >= coffeeBeansForCoffee &&
        milk >= milkForCoffee
    ) {
        print("I have enough resources, making you a coffee!")
        println()
        water -= waterForCoffee
        milk -= milkForCoffee
        coffee_beans -= coffeeBeansForCoffee
        cups -= 1
        money += moneyForCoffee
        println()
        //take()
    } else {
        if (water < waterForCoffee) {
            lack = "water"
        }

        if (milk < milkForCoffee) {
            lack = "milk"
        }
        if (coffee_beans < coffeeBeansForCoffee) {
            lack = "coffee beans"
        }
        println("Sorry, not enough $lack!")
        println()
    }


}
