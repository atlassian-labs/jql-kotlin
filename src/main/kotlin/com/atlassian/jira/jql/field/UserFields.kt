package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.UserEqualityFunction
import com.atlassian.jira.jql.function.UserInclusionFunction

abstract class AbstractUserField(name: String, vararg alias: String) : Field(name, *alias) {
    infix fun equalTo(value: String): Clause = _equalTo { value.escape() }
    infix fun equalTo(function: UserEqualityFunction): Clause = _equalTo(function)
    infix fun notEqualTo(value: String): Clause = _notEqualTo { value.escape() }
    infix fun notEqualTo(function: UserEqualityFunction): Clause = _notEqualTo(function)
    infix fun anyOf(values: Collection<String>): Clause = _anyOf { values.map { it.escape() } }
    infix fun anyOf(function: UserInclusionFunction): Clause = _anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = _noneOf { values.map { it.escape() } }
    infix fun noneOf(function: UserInclusionFunction): Clause = _noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = _iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = _izNot { value }
}

object Assignee : AbstractUserField("assignee"), SortableField

object Creator : AbstractUserField("creator"), SortableField

object Reporter : AbstractUserField("reporter"), SortableField

object Voter : AbstractUserField("voter")

object Watcher : AbstractUserField("watcher")
