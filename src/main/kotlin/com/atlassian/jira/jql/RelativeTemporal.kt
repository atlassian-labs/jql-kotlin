package com.atlassian.jira.jql

interface RelativeTemporal {
    val jql: String
}

data class RelativeDate internal constructor(
    val negative: Boolean,
    val weeks: Int,
    val days: Int,
) : RelativeTemporal {
    constructor(weeks: Int = 0, days: Int = 0) : this(false, weeks, days)

    init {
        validateComponents(weeks, days)
    }

    override val jql = arrayOf(weeks.weeks(), days.days()).toJqlRelativeTemporal(negative)

    operator fun unaryMinus() = this.copy(negative = !negative)
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
        validateComponents(weeks, days, hours, minutes)
    }

    override val jql = arrayOf(weeks.weeks(), days.days(), hours.hours(), minutes.minutes()).toJqlRelativeTemporal(negative)

    operator fun unaryMinus() = this.copy(negative = !negative)
}

data class RelativeTime internal constructor(
    val negative: Boolean,
    val hours: Int,
    val minutes: Int,
) : RelativeTemporal {
    constructor(hours: Int = 0, minutes: Int = 0) : this(false, hours, minutes)

    init {
        validateComponents(hours, minutes)
    }

    override val jql = arrayOf(hours.hours(), minutes.minutes()).toJqlRelativeTemporal(negative)

    operator fun unaryMinus() = this.copy(negative = !negative)
}

private fun validateComponents(vararg component: Int) {
    require(
        component.all { it >= 0 }
    ) { "Components must not have negative values" }
    require(
        component.any { it > 0 }
    ) { "At least one component must have a positive value" }
}

private fun Int.weeks() = temporal('w')
private fun Int.days() = temporal('d')
private fun Int.hours() = temporal('h')
private fun Int.minutes() = temporal('m')

private fun Int.temporal(unit: Char) = takeIf { it > 0 }?.let { "$this$unit" } ?: ""

private fun Array<String>.toJqlRelativeTemporal(negative: Boolean) =
    filter { it.isNotBlank() }
        .joinToString(prefix = "\"${if (negative) "-" else ""}", separator = " ", postfix = "\"")
