package com.atlassian.jira.jql.time

interface Duration {
    val jql: String
    val ago: RelativeDateTime get() = relativeDateTime(jql, negative = true)
    val fromNow: RelativeDateTime get() = relativeDateTime(jql)
}

interface DateDuration : Duration {
    override val ago: RelativeDate get() = relativeDate(jql, negative = true)
    override val fromNow: RelativeDate get() = relativeDate(jql)
}

interface TimeDuration : Duration {
    override val ago get() = relativeTime(jql, negative = true)
    override val fromNow get() = relativeTime(jql)
}

open class DateTimeDuration internal constructor(
    val weeks: Weeks = 0.weeks,
    val days: Days = 0.days,
    val hours: Hours = 0.hours,
    val minutes: Minutes = 0.minutes,
) : Duration {
    override val jql = arrayOf(weeks, days, hours, minutes)
        .map { it.jql.trim('"') }
        .filter { it.isNotBlank() }
        .joinToString(prefix = "\"", separator = " ", postfix = "\"")
}

abstract class AbstractDurationComponent(internal val value: Int, unit: Char) {
    init {
        require(value >= 0) { "Duration component can't be negative" }
    }

    val jql = value.takeIf { it > 0 }?.let { "\"$it$unit\"" } ?: ""
}

class Weeks internal constructor(value: Int) : AbstractDurationComponent(value, 'w'), DateDuration {
    operator fun plus(days: Days) = WeeksAndDays(weeks = this, days = days)
    operator fun plus(hours: Hours) = WeeksDaysAndHours(weeks = this, hours = hours)
    operator fun plus(minutes: Minutes) = DateTimeDuration(weeks = this, minutes = minutes)
}

class Days(value: Int) : AbstractDurationComponent(value, 'd'), DateDuration {
    operator fun plus(hours: Hours) = WeeksDaysAndHours(days = this, hours = hours)
    operator fun plus(minutes: Minutes) = DateTimeDuration(days = this, minutes = minutes)
}

class Hours(value: Int) : AbstractDurationComponent(value, 'h'), TimeDuration {
    operator fun plus(minutes: Minutes) = HoursAndMinutes(hours = this, minutes = minutes)
}

class Minutes(value: Int) : AbstractDurationComponent(value, 'm'), TimeDuration

class WeeksAndDays internal constructor(
    weeks: Weeks = 0.weeks,
    days: Days = 0.days,
) : DateTimeDuration(weeks = weeks, days = days), DateDuration {
    operator fun plus(hours: Hours) = WeeksDaysAndHours(weeks, days, hours)
    operator fun plus(minutes: Minutes) = DateTimeDuration(weeks, days, minutes = minutes)
}

class WeeksDaysAndHours internal constructor(
    weeks: Weeks = 0.weeks,
    days: Days = 0.days,
    hours: Hours = 0.hours,
) : DateTimeDuration(weeks = weeks, days = days, hours = hours) {
    operator fun plus(minutes: Minutes) = DateTimeDuration(weeks, days, hours, minutes)
}

class HoursAndMinutes internal constructor(
    hours: Hours = 0.hours,
    minutes: Minutes = 0.minutes,
) : DateTimeDuration(hours = hours, minutes = minutes), TimeDuration

val Int.weeks get() = Weeks(this)
val Int.w get() = weeks
val Int.days get() = Days(this)
val Int.d get() = days
val Int.hours get() = Hours(this)
val Int.h get() = hours
val Int.minutes get() = Minutes(this)
val Int.m get() = minutes
