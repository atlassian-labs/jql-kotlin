package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape
import com.atlassian.jira.jql.function.UserEqualityFunction
import com.atlassian.jira.jql.function.UserInclusionFunction

abstract class AbstractUserField(name: String) : Field(name) {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun equalTo(function: UserEqualityFunction): Clause = super.equalTo(function)
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun notEqualTo(function: UserEqualityFunction): Clause = super.notEqualTo(function)
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun anyOf(function: UserInclusionFunction): Clause = super.anyOf(function)
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun noneOf(function: UserInclusionFunction): Clause = super.noneOf(function)
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Assignee : AbstractUserField("assignee"), SortableField

object Creator : AbstractUserField("creator"), SortableField

object Reporter : AbstractUserField("reporter"), SortableField

object Voter : AbstractUserField("voter")

object Watcher : AbstractUserField("watcher")
