

import kotlinx.datetime.*
import kotlin.time.Duration


fun main() {
    val inst1 = Instant.parse("2022-02-01T22:10:01.324Z")
    println(inst1) // 2022-02-01T22:10:01.324Z

    val inst2 = "2022-02-01T22:10:01.324Z".toInstant()
    println(inst2)  // 2022-02-01T22:10:01.324Z

    val instant3 = "2022-02-01T09:10:01.324+10:00".toInstant()
    println(instant3)  // 2022-01-31T23:10:01.324Z


    val tz1 = TimeZone.currentSystemDefault()  // The computer system time zone

    val tz2 = TimeZone.UTC                     // UTC time zone
    println(tz2)

    val tz3 = TimeZone.of("Europe/Paris")      // Paris, France time zone
    println(tz3)                               // Europe/Paris

    val tz4 = TimeZone.of("UTC+2")             // UTC + 2 hours time zone
    println(tz4)


    val instant1 = Instant.parse("2022-01-01T00:00:00Z")
    val instant2 = Instant.parse("2022-02-03T04:05:06Z")

// instant2 - instant1
    println(instant1.until(instant2, DateTimeUnit.WEEK, TimeZone.UTC))    // 4
    println(instant1.until(instant2, DateTimeUnit.DAY, TimeZone.UTC))     // 33
    println(instant1.until(instant2, DateTimeUnit.HOUR, TimeZone.UTC))    // 796
    println(instant1.until(instant2, DateTimeUnit.HOUR))                  // 796
    println(instant1.until(instant2, DateTimeUnit.SECOND, TimeZone.UTC))  // 2865906
    println(instant1.until(instant2, DateTimeUnit.SECOND))                // 2865906

// instant1 - instant2
    println(instant2.until(instant1, DateTimeUnit.WEEK, TimeZone.UTC))    // -4

    if (instant1 > instant2)
        println(instant1)
    else
        println(instant2)

// Prints 2022-02-03T04:05:06Z

    val instant5 = Instant.parse("2000-01-01T20:00:00Z")
    val instant6 = Instant.parse("2012-10-14T05:20:30Z")

    val duration: Duration = instant6 - instant5
    println(duration)
// 8124d 16h 29m 37.716s


    val instant7 = Instant.parse("2000-01-01T20:00:00Z")
    val instant8 = Instant.parse("2000-10-14T00:00:00Z")

    val period: DateTimePeriod = instant7.periodUntil(instant8, TimeZone.UTC)

    println(period)
// P9M12DT4H

    println("Months: ${period.months} Days: ${period.days} Hours: ${period.hours}")
// Months: 9 Days: 12 Hours: 4



    val instant = Instant.parse("2000-01-01T00:00:00Z")
    println(instant)
// 2000-01-01T00:00:00Z

    val period2: DateTimePeriod = DateTimePeriod(years = 1, months = 1, days = 1, hours = 1, minutes = 1, seconds = 1, nanoseconds = 123456789L)
    println(period2)
// P1Y1M1DT1H1M1.123456789S

    val after = instant.plus(period2, TimeZone.UTC)

    println(after)
// 2001-02-02T01:01:01.123456789Z

    val before = instant.minus(period2, TimeZone.UTC)

    println(before)
// 1998-11-29T22:58:58.876543211Z


    val instant9 = Instant.parse("2100-01-01T00:00:00Z")
    val instant10 = Instant.parse("2105-07-09T15:23:40Z")

    val duration2: Duration = instant10 - instant9
    println(duration2)                                             // 2015d 15h 23m 40s
    println(duration2.inWholeDays)                                 // 2015
    println(duration2.inWholeHours)                                // 48375

    println( instant9.periodUntil(instant10, TimeZone.UTC) )       // P5Y6M8DT15H23M40S
    println( instant9.periodUntil(instant10, TimeZone.UTC).days )  // 8
}