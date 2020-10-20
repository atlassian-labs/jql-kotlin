package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.function.SlaComparativeFunction
import com.atlassian.jira.jql.function.SlaEqualityFunction
import com.atlassian.jira.jql.time.RelativeTime

// Intentionally omitted EQUALS, NOT EQUALS with relative time argument as they don't make much sense here
// given that they require minute precision values equality.
abstract class AbstractSlaField(name: String) : Field(name), SortableField {
    infix fun equalTo(function: SlaEqualityFunction) = super.equalTo(function)
    infix fun notEqualTo(function: SlaEqualityFunction): Clause = super.notEqualTo(function)
    infix fun greaterThan(value: RelativeTime): Clause = greaterThan { value.jql }
    infix fun greaterThan(function: SlaComparativeFunction): Clause = super.greaterThan(function)
    infix fun greaterThanOrEqualTo(value: RelativeTime): Clause = greaterThanOrEqualTo { value.jql }
    infix fun greaterThanOrEqualTo(function: SlaComparativeFunction): Clause = super.greaterThanOrEqualTo(function)
    infix fun lessThan(value: RelativeTime): Clause = lessThan { value.jql }
    infix fun lessThan(function: SlaComparativeFunction): Clause = super.lessThan(function)
    infix fun lessThanOrEqualTo(value: RelativeTime): Clause = lessThanOrEqualTo { value.jql }
    infix fun lessThanOrEqualTo(function: SlaComparativeFunction): Clause = super.lessThanOrEqualTo(function)
}

object Sla {
    object TimeToResolution : AbstractSlaField("\"Time to resolution\"")

    object TimeToFirstResponse : AbstractSlaField("\"Time to first response\"")

    fun custom(jql: String) = object : AbstractSlaField(jql) {}
}
