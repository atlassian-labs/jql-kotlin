package com.atlassian.jira.jql

interface RelativeTemporal : JqlEntity

data class RelativeDate internal constructor(
    val negative: Boolean,
    val weeks: Int,
    val days: Int,
) : RelativeTemporal {
    constructor(weeks: Int = 0, days: Int = 0) : this(false, weeks, days)

    init {
        require(
            sequenceOf(weeks, days).all { it >= 0 }
        ) { "Components must not have negative values" }
        require(
            sequenceOf(weeks, days).any { it > 0 }
        ) { "At least one component must have a positive value" }
    }

    operator fun unaryMinus() = this.copy(negative = !negative)

    override fun toJql() = arrayOf(weeks.weeks(), days.days()).toJql(negative)
}

data class RelativeDateTime internal constructor(
    val negative: Boolean,
    val weeks: Int,
    val days: Int,
    val hours: Int,
    val minutes: Int,
) : RelativeTemporal {
    constructor(
        weeks: Int = 0,
        days: Int = 0,
        hours: Int = 0,
        minutes: Int = 0,
    ) : this(false, weeks, days, hours, minutes)

    init {
        require(
            sequenceOf(weeks, days, hours, minutes).all { it >= 0 }
        ) { "Components must not have negative values" }
        require(
            sequenceOf(weeks, days, hours, minutes).any { it > 0 }
        ) { "At least one component must have a positive value" }
    }

    operator fun unaryMinus() = this.copy(negative = !negative)

    override fun toJql() = arrayOf(weeks.weeks(), days.days(), hours.hours(), minutes.minutes()).toJql(negative)
}

private fun Int.weeks() = temporal('w')
private fun Int.days() = temporal('d')
private fun Int.hours() = temporal('h')
private fun Int.minutes() = temporal('m')

private fun Int.temporal(unit: Char) = takeIf { it > 0 }?.let { "$this$unit" } ?: ""

private fun Array<String>.toJql(negative: Boolean) =
    filter { it.isNotBlank() }
        .joinToString(prefix = "\"${if (negative) "-" else ""}", separator = " ", postfix = "\"")
