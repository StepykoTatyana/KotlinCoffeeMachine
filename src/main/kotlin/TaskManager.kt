import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.datetime.*

import kotlinx.datetime.*

var mapWithInputTask = mutableMapOf<Int, Task>()
var priorityTask: String = ""
var dateTask: String = ""
var timeTask: String = ""
var dateTimeArray: List<String> = arrayListOf()
var taskValue: String = ""
var numTask: Int = 1

fun main() {
    while (true) {
        println("Input an action (add, print, edit, delete, end):")
        when (readln()) {

            "add" -> {

                priority()
                dateTask()
                dateTimeTask()
                add()
            }

            "print" -> {
                print()
            }

            "delete" -> {
                delete()
            }

            "edit" -> {
                edit()
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

fun add() {
    println("Input a new task (enter a blank line to end):")
    taskValue = ""
    val taskArray = arrayListOf<String>()
    var j = 1
    while (true) {

        val input = readln().trim()
        if (input == "") {
            break
        } else {
            taskValue += if (j > 1) {
                taskArray.addAll(input.chunked(44))
                "\n$input"
            } else {
                taskArray.addAll(input.chunked(44))
                input
            }
            j++
        }
    }
    if (taskValue != "") {
        try {
            taskValue = taskArray.joinToString("|\n|    |            |       |   |   |") { it.padEnd(44) } + "|"
            val task = Task(
                priorityTask,
                dateTask,
                timeTask,
                taskValue
            )

            val taskJson = TaskJson(
                priorityTask,
                dateTask,
                timeTask,
                task.getOverdueFlag(),
                taskValue.replace("|","").trim()
            )
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val newAdapter = moshi.adapter(TaskJson::class.java)

            println(newAdapter.toJson(taskJson))
            var newHumanString = newAdapter.toJson(taskJson)

            val newHuman = newAdapter.fromJson(newHumanString)
            try {
                val newTask = newHuman?.let { Task(newHuman.priority,it.date, newHuman.time, newHuman.tasks) }
                if (newTask != null) {
                    println(newTask.toString(1))
                }
            } catch (e: Exception) {
                println(e.message)
            }

            if (newHuman != null) {
                println(newHuman.date)
            }
            if (newHuman != null) {
                println(newHuman.tasks)
            }


            mapWithInputTask[numTask] = task
            numTask++
        } catch (e: java.lang.Exception) {
            taskValue = taskArray.joinToString("|\n|    |            |       |   |   |") { it.padEnd(44) } + "|"
        }
    } else {
        println("The task is blank")
    }
}


fun print() {

    if (mapWithInputTask.isNotEmpty()) {
        println("+----+------------+-------+---+---+--------------------------------------------+")
        println("| N  |    Date    | Time  | P | D |                   Task                     |")
        println("+----+------------+-------+---+---+--------------------------------------------+")

        var j = 1
        for (i in mapWithInputTask.values) {

            println(i.toString(j))
            println("+----+------------+-------+---+---+--------------------------------------------+")
            j++
        }
    } else {
        println("No tasks have been input")
    }
}

fun delete() {
    if (mapWithInputTask.isNotEmpty()) {
        print()
        while (true) {
            println("Input the task number (1-${mapWithInputTask.size}):")
            try {
                val numForDelete = readln().toInt()
                if (numForDelete <= 0 || numForDelete > mapWithInputTask.size) {
                    println("Invalid task number")
                } else {
                    println("The task is deleted")
                    mapWithInputTask.remove(numForDelete)
                    val mapNew = mutableMapOf<Int, Task>()
                    for (m in mapWithInputTask.values) {
                        mapNew[mapWithInputTask.values.indexOf(m) + 1] = m
                    }
                    mapWithInputTask = mapNew
                    break
                }
            } catch (e: Exception) {
                println("Invalid task number")
            }
        }
    } else {
        println("No tasks have been input")
    }
}

fun edit() {
    if (mapWithInputTask.isNotEmpty()) {
        print()
        loop@ while (true) {
            println("Input the task number (1-${mapWithInputTask.size}):")
            try {

                val numForEdit = readln().toInt()
                if (numForEdit <= 0 || numForEdit > mapWithInputTask.size) {
                    println("Invalid task number")
                } else {
                    for (m in mapWithInputTask.entries) {
                        if (numForEdit == m.key) {
                            numTask = m.key
                            priorityTask = m.value.getPriority().name
                            dateTask = m.value.getDate()
                            timeTask = m.value.getTime()
                            taskValue = m.value.getTasks()
                            while (true) {
                                println("Input a field to edit (priority, date, time, task):")
                                when (readln()) {
                                    "priority" -> {
                                        priority()
                                        break
                                    }

                                    "date" -> {
                                        dateTask()
                                        break
                                    }

                                    "time" -> {
                                        dateTimeTask()
                                        break
                                    }

                                    "task" -> {
                                        add()
                                        break
                                    }

                                    else -> {

                                        println("Invalid field")

                                    }
                                }
                            }
                            m.value.setPriority(priorityTask)
                            m.value.setDate(dateTask)
                            m.value.setTime(timeTask)
                            m.value.setTasks(taskValue)
                            m.value.setOverdueFlag()
                            println("The task is changed")
                            break@loop
                        }
                    }
                }

            } catch (e: Exception) {
                println("Invalid task number")
            }
        }
    } else {
        println("No tasks have been input")
    }
}

fun priority() {
    while (true) {
        println("Input the task priority (C, H, N, L):")
        priorityTask = readln().uppercase()

        if (priorityTask.lowercase() in arrayOf("c", "h", "n", "l")) {
            break
        }
    }
}

fun dateTimeTask() {
    val regexTime = "(([0-1][0-9])|(2[0-3])|[0-9]):(([0-5][0-9])|[0-9])".toRegex()


    while (true) {
        println("Input the time (hh:mm):")
        timeTask = readln()

        if (timeTask.matches(regexTime)) {
            try {
                val timeTimeArray = timeTask.split(":")
                val timeForWriting = LocalDateTime(
                    dateTimeArray[0].toInt(),
                    dateTimeArray[1].toInt(), dateTimeArray[2].toInt(),
                    timeTimeArray[0].toInt(), timeTimeArray[1].toInt()
                )
                timeTask = timeForWriting.toString().split("T")[1]
                break
            } catch (e: Exception) {
                println("The input time is invalid")
            }

        } else {
            println("The input time is invalid")
        }
    }
}


fun dateTask() {
    val regex = "[0-9]{4}-(0[0-9]|1[0-2]|[0-9])-([0-2][0-9]|3[0-1]|[0-9])".toRegex()


    while (true) {
        println("Input the date (yyyy-mm-dd):")
        dateTask = readln()

        if (dateTask.matches(regex)) {
            try {
                dateTimeArray = dateTask.split("-")
                val dateForWriting =
                    LocalDate(dateTimeArray[0].toInt(), dateTimeArray[1].toInt(), dateTimeArray[2].toInt())
                dateTask = dateForWriting.toString()
                break
            } catch (e: Exception) {
                println("The input date is invalid")
            }
        } else {
            println("The input date is invalid")
        }
    }
}