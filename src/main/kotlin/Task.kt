
import kotlinx.datetime.*

class Task(_priority: String, _date: String, _time: String, _tasks: String) {
    private var priority: Priority
    fun getPriority(): String {
        return priority.toString()
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

    private var overdueFlag: String = getOverdueFlag()
    fun setOverdueFlag() {
        val dateTimeArray = date.split("-")
        val dateForWriting =
            LocalDate(dateTimeArray[0].toInt(), dateTimeArray[1].toInt(), dateTimeArray[2].toInt())
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date
        val numberOfDays = currentDate.daysUntil(dateForWriting)
        overdueFlag = if (numberOfDays == 0) {
            "T"
        } else if (numberOfDays > 1) {
            "I"
        } else {
            "O"
        }
    }

    private fun getOverdueFlag(): String {
        setOverdueFlag()
        return overdueFlag
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
            "$key  $date $time $priority $overdueFlag\n$tasks"
        } else {
            "$key $date $time $priority $overdueFlag\n$tasks"
        }
    }


}

enum class Priority {
    C,
    H,
    N,
    L;

}