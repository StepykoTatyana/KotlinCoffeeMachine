import kotlin.math.pow



class VinylStore(private val vinyl: String) {
    fun printVinyl() {
        println(this.vinyl)
    }
}

enum class Currency(var code: String) {
    USD("United States dollar"),
    EUR("Euro"),
    GBP("Pound sterling"),
    RUB("Russian ruble"),
    UAH("Ukrainian hryvnia"),
    KZT("Kazakhstani tenge"),
    CAD("Canadian dollar"),
    JPY("Japanese yen"),
    CNY("Chinese yuan");

    fun new() {

    }
}

enum class DaysOfTheWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}


enum class Rainbow(val colorName: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet"),
    NULL("")
}

fun findByName(name: String): Rainbow {
    for (color in Rainbow.values()) {
        if (name == color.colorName) return color
    }
    return Rainbow.NULL
}

enum class DangerLevel(private val dangerLevel: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel(): Int {
        return dangerLevel;
    }
}


fun main() {
    val high = DangerLevel.HIGH
    val medium = DangerLevel.MEDIUM

    println(high.getLevel() > medium.getLevel())
    val color = findByName("Black")
    println(color.ordinal)
    for (enum in DaysOfTheWeek.values()) {
        println(enum.name)
    }
    val parameter1 = readln()
    val parameter2 = readln().toInt()
    when (parameter1) {
        "amount" -> amount(amount = parameter2)
        "percent" -> amount(percent = parameter2)
        "years" -> amount(years = parameter2)
    }

    val coffeeMachine = CoffeeMachine()
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val action = readln()
        if (action == "exit") {
            break
        } else {
            coffeeMachine.setAction(action)
        }
    }


}


fun amount(amount: Int = 1000, percent: Int = 5, years: Int = 10) {
    println((amount * ((1 + percent.toDouble() / 100).pow(years))).toInt())
}
