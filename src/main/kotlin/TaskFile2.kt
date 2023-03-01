fun main() {
    mutableListOf<MutableList<String>>().action()
}

fun MutableList<MutableList<String>>.action() {
    when (println("Input an action (add, print, end):").run { readln() }) {
        "add" -> addTask()
        "print" -> printTasks()
        "end" -> println("Tasklist exiting!").run { return }
        else -> println("The input action is invalid")
    }
    action()
}

fun MutableList<MutableList<String>>.addTask() {
    println("Input a new task (enter a blank line to end):")
    with(mutableListOf<String>()) {
        addToDoList().also { if (isNotEmpty()) add(this) else println("The task is blank") }
    }
}

fun MutableList<String>.addToDoList() {
    readln().trimIndent().let { if (it.isNotEmpty()) this.add(it).also { addToDoList() } }
}

fun MutableList<MutableList<String>>.printTasks() {
    if (isEmpty()) println("No tasks have been input")
    mapIndexed { index, ToDoList ->
        println(
            "${(index + 1).let { if (it < 10) "$it  " else "$it " }}${ToDoList.joinToString("\n   ")}\n"
        )
    }
}
