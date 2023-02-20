import java.util.*

fun main() {

//    val text = readln()
//    // write your code here
//    val processedString = text.replace("[Aa]+".toRegex(), "a")
//    println(processedString)


    val text3 =
        "Phone 1: 123-213-1234. Phone 2: 99954654654. Phone 3: (887)6523456. Phone 4: (988)-745-9821"

    val regexPhone = "(\\(?[0-8]{3}\\)?-[0-8]{3}-[0-8]{4})|(\\(?[0-8]{3}\\)?[0-8]{7})".toRegex()
    val matchResultPhone =
        regexPhone.findAll(text3)
    for (m in matchResultPhone) println(m.value)

    val text2 =
        "Web_colors_are_colors_used_when_displaying_web_pages."
    val regex = "_[a-zA-Z]+".toRegex()
    val list = text2.split("_").toMutableList()

    for (i in 0 until list.size) {
        list[i] = list[i].replaceFirstChar { it.uppercase() }
    }
    //println(list)
    //for (matches in list) matches.replaceFirstChar{ it.uppercase() }
    println(list.joinToString(""))
    val matchResult =
        regex.findAll(text2)

//    for (matches in matchResult) text2.replace(matches.value, matches.value.uppercase()).replace("_", "")
//    println(text2)
    printIfPrime(5)
    val parkingClass = ParkingClass()
    while (true) {
        val action = readln()
        if (action == "exit") {
            break
        } else {
            parkingClass.setAction(action)
        }
    }

}

fun printIfPrime(number: Int) {
    var prime = true
    if (number != 1) {
        for (i: Int in 2 until number) {
            if (number % i == 0) {
                prime = false
                break
            }
        }

    }
    if (prime) {
        println("$number is a prime number.")
    } else {
        println("$number is not a prime number.")
    }
}


fun listT(numbers : List<Int>, Num : Int) : MutableList<Int>{
    val mutableList = mutableListOf<Int>()
    mutableList.addAll(numbers)
    mutableList.add(Num)
    return mutableList
}



