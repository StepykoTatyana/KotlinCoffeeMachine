import kotlinx.datetime.*


fun main() {


    val date = Instant.parse(readln())

    val datetime = DateTimePeriod(months = 1)
    println(date.plus(datetime, TimeZone.UTC).toString())




}