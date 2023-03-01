import kotlinx.datetime.*

class Task(
    _priority: String, _date: String, _time: String, _tasks: String) {
    private var priority: Priority
    fun getPriority(): Priority {
        return priority
    }

    fun setPriority(value: String) {
        priority = Priority.valueOf(value)
    }

    private var date: String = _date
    fun setDate(value: String) {
        date = value
    }

    fun getDate(): String {
        return date
    }

    private var time: String = _time
    fun setTime(value: String) {
        time = value
    }

    fun getTime(): String {
        return time
    }

    private var overdueFlag: Overdue = Overdue.valueOf(getOverdueFlag())
    fun setOverdueFlag() {
        val dateTimeArray = date.split("-")
        val dateForWriting =
            LocalDate(dateTimeArray[0].toInt(), dateTimeArray[1].toInt(), dateTimeArray[2].toInt())
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date
        val numberOfDays = currentDate.daysUntil(dateForWriting)


        overdueFlag = if (numberOfDays == 0) {
            Overdue.T
        } else if (numberOfDays > 0) {
            Overdue.I
        } else {
           Overdue.O
        }
    }

    fun getOverdueFlag(): String {
        setOverdueFlag()
        return overdueFlag.name
    }

    private var tasks: String = _tasks
    fun setTasks(value: String) {
        tasks = value
    }

    fun getTasks(): String {
        return tasks
    }


    init {
        priority = Priority.valueOf(_priority)
    }


    fun toString(key: Int): String {
        return if (key.toString().length == 1) {
            "| $key  | $date | $time | ${priority.getColor()} | ${overdueFlag.getColor()} |$tasks"
        } else {
            "| $key | $date | $time | ${priority.getColor()} | ${overdueFlag.getColor()} |$tasks"
        }
    }


}

enum class Priority(private val color: String) {
    C("\u001B[101m \u001B[0m"),
    H("\u001B[103m \u001B[0m"),
    N("\u001B[102m \u001B[0m"),
    L("\u001B[104m \u001B[0m");

    fun getColor(): String {
        return color;
    }
}

enum class Overdue(private val color: String) {

    O("\u001B[101m \u001B[0m"),
    T("\u001B[103m \u001B[0m"),
    I("\u001B[102m \u001B[0m");

    fun getColor(): String {
        return color;
    }
}