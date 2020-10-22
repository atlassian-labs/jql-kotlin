package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.Identifier
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.VersionEqualityFunction
import com.atlassian.jira.jql.function.VersionInclusionFunction

abstract class AbstractVersionField(name: String) : Field(name), SortableField {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(value: Identifier): Clause = _equalTo { value.toString() }
    infix fun equalTo(function: VersionEqualityFunction): Clause = _equalTo(function)
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(value: Identifier): Clause = _notEqualTo { value.toString() }
    infix fun notEqualTo(function: VersionEqualityFunction): Clause = _notEqualTo(function)
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(values: Identifiers): Clause = _anyOf { values.identifiers.map { it.toString() } }
    infix fun anyOf(function: VersionInclusionFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(values: Identifiers): Clause = _noneOf { values.identifiers.map { it.toString() } }
    infix fun noneOf(function: VersionInclusionFunction): Clause = _noneOf(function)
    infix fun greaterThan(value: String): Clause = _greaterThan { value.escape() }
    infix fun greaterThan(value: Identifier): Clause = _greaterThan { value.toString() }
    infix fun greaterThanOrEqualTo(value: String): Clause = _greaterThanOrEqualTo { value.escape() }
    infix fun greaterThanOrEqualTo(value: Identifier): Clause = _greaterThanOrEqualTo { value.toString() }
    infix fun lessThan(value: String): Clause = _lessThan { value.escape() }
    infix fun lessThan(value: Identifier): Clause = _lessThan { value.toString() }
    infix fun lessThanOrEqualTo(value: String): Clause = _lessThanOrEqualTo { value.escape() }
    infix fun lessThanOrEqualTo(value: Identifier): Clause = _lessThanOrEqualTo { value.toString() }
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object AffectedVersion : AbstractVersionField("affectedVersion")

object FixVersion : AbstractVersionField("fixVersion")
