import java.lang.Exception
import kotlin.math.max

fun main() {
    val mapWithInput = mutableMapOf<Int, String>()
    var i = 1
    while (true) {
        println("Input an action (add, print, end):")
        when (readln()) {
            "add" -> {
                println("Input a new task (enter a blank line to end):")
                var taskList = ""
                var j = 1
                while (true) {
                    val input = readln().trim()
                    if (input == "") {
                        break
                    } else {
                        if (j == 1) {
                            taskList += "$i\t" + input + "\n"
                            j++
                        } else {
                            taskList += "\t" + input + "\n"
                        }


                    }
                }
                if (taskList != "") {
                    mapWithInput[i] = taskList
                    i++
                } else {
                    println("The task is blank")
                }

            }


            "print" -> {
                if (mapWithInput.isNotEmpty()) {
                    for (str in mapWithInput) {
                        //print(str.key)
                        println(str.value)
                    }
                } else {
                    println("No task have been input")
                }
            }

            "end" -> {
                println("Tasklist exiting!")
                break
            }

            else -> {
                println("The input action is invalid")
            }
        }
    }


}

fun arrayTask() {
    //    1 вариант
    val n = readln().toInt()
    val list = IntArray(n)
    for (i in 0 until n) {
        list[i] = readln().toInt()
    }

//    2 вариант

    val listArray = Array(readln().toInt()) { readln().toInt() }


    val m = readln().toInt()
    println(list.filter { x -> x == m }.size)
}

fun arrayTask2() {
    val n = readln().toInt()
    val listCompany = Array(n) { readln().toInt() }

    val list = readln().split(" ")
    val p = list[0].toInt()
    val m = list[1].toInt()
    var flag = false
    for (i in listCompany.indices) {
        if (listCompany[i] == p || listCompany[i] == m) {
            flag = if (listCompany[i] == p)
                try {
                    listCompany[i + 1] == m

                } catch (e: Exception) {
                    false
                }
            else {
                try {
                    listCompany[i + 1] == p
                } catch (e: Exception) {
                    false
                }
            }
            if (flag) break
        }
    }
    if (flag) println("NO") else println("YES")


}