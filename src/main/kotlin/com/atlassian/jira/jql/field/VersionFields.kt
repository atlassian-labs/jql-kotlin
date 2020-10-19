package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.VersionEqualityFunction

abstract class AbstractVersionField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = equalTo { value.toString() }
    infix fun equalTo(function: VersionEqualityFunction): Clause = equalTo { function.toJql() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = notEqualTo { value.toString() }
    infix fun notEqualTo(function: VersionEqualityFunction): Clause = notEqualTo { function.toJql() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = anyOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = noneOf { values.identifiers.map { it.toString() } }
    infix fun greaterThan(value: String): Clause = greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object AffectedVersion : AbstractVersionField("affectedVersion")

object FixVersion : AbstractVersionField("fixVersion")
