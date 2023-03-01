data class TaskJson(
    var priority: String,
    var date: String,
    var time: String,
    var overdueFlag: String,
    var tasks: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskJson

        if (priority != other.priority) return false
        if (date != other.date) return false
        if (time != other.time) return false
        if (overdueFlag != other.overdueFlag) return false
        if (!tasks.contentEquals(other.tasks)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = priority.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + overdueFlag.hashCode()
        result = 31 * result + tasks.contentHashCode()
        return result
    }
}