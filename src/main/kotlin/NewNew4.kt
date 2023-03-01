import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File
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

data class Article(val name: String, val pages: Int, val author: String) {

}

fun getArticleByName(articles: MutableList<Article>, name: String): Article? {
    var index = -1
    for ((title, pages, author) in articles) {
        index += 1
        if (title == name) return articles[index]
    }
    return null
}


data class Customer(val firstName: String, val lastName: String, val age: Int, val city: String)


class CustomerFilter {
    fun showCustomers(customers: MutableList<Customer>) {
        for ((p1, _, p3) in customers) {
            if (p3 in 18..27) println(p1)
        }
    }
}


data class Comment(val id: Int, val body: String, val author: String)

fun printComments(commentsData: MutableList<Comment>) {
    for ((_, p2, p3) in commentsData) {
        println("Author: $p3; Text: $p2")
    }
}

fun main() {
    class Human(var name: String, var age: Int, var friends: Array<String>)
    val human = Human("Mike", 20, arrayOf("Alex", "Valery", "Ann"))
    val moshi = Moshi.Builder().build()
//        .add(KotlinJsonAdapterFactory())
//        .build()

    val humanAdapter = moshi.adapter(Human::class.java)

    print(humanAdapter.toJson(human))
// {"name":"Mike","age":20,"friends":["Alex","Valery","Ann"]}

    val newHumanString = """
    {"name":"John",
    "age":25, 
    "friends":["Mike","Helen"]}""".trimIndent()

    val newHuman = humanAdapter.fromJson(newHumanString)


    val humanList = listOf(human, newHuman)

    val type = Types.newParameterizedType(List::class.java, Human::class.java)
    val humanListAdapter = moshi.adapter<List<Human?>>(type)
    print(humanListAdapter.toJson(humanList)) // [{"name":"Mike","age":20,"friends":["Alex","Valery","Ann"]},{"name":"John","age":25,"friends":["Mike","Helen"]}]

    val jsonStr =
        """[{"name":"Nick","age":10,"friends":["Valery"]},
       {"name":"John","age":25,"friends":[]},
       {"name":"Kate","age":40,"friends":[]}]
       """.trimIndent()

    val newHumanList = humanListAdapter.fromJson(jsonStr)



    val workingDirectory = System.getProperty ("user.dir")
    println(workingDirectory)

    // separator
    val separator = File.separator

//combine path to string:
    val absolutePath = "${System.getProperty ("user.dir")}${separator}words_with_numbers.txt"

    println(separator)
    println(absolutePath)

    var i = 0
    val file = File("C:\\IdeaProjects\\KotlinProjects1\\src\\main\\kotlin\\words_with_numbers.txt")
    for (l in file.readLines()){
        for (a in l){
            if (a.isDigit()){
                i++
                break
            }
        }

    }
    println(i)


    val customer = Customer("dfsdf", "rettttt", 34, "fddgdf")
    val customerFilter = CustomerFilter()
    customerFilter.showCustomers(mutableListOf(customer, customer))

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
