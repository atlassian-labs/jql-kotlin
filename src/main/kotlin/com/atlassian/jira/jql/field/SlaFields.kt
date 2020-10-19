package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.time.RelativeTime

// Intentionally omitted EQUALS, NOT EQUALS as they don't make much sense here
// given that they require minute precision values equality.
abstract class AbstractSlaField(name: String) : Field(name), SortableField {
    infix fun greaterThan(value: RelativeTime): Clause = greaterThan { value.jql }
    infix fun greaterThanOrEqualTo(value: RelativeTime): Clause = greaterThanOrEqualTo { value.jql }
    infix fun lessThan(value: RelativeTime): Clause = lessThan { value.jql }
    infix fun lessThanOrEqualTo(value: RelativeTime): Clause = lessThanOrEqualTo { value.jql }
}

object Sla {
    object TimeToResolution : AbstractSlaField("\"Time to resolution\"")

    object TimeToFirstResponse : AbstractSlaField("\"Time to first response\"")

    fun custom(jql: String) = object : AbstractSlaField(jql) {}
}
