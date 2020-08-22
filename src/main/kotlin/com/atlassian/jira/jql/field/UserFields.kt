package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape

abstract class AbstractUserField(name: String) : Field(name) {
    infix fun equalTo(value: String): Clause = equalTo { value.escape() }
    infix fun notEqualTo(value: String): Clause = notEqualTo { value.escape() }
    infix fun anyOf(values: Collection<String>): Clause = anyOf { values.map { it.escape() } }
    infix fun noneOf(values: Collection<String>): Clause = noneOf { values.map { it.escape() } }
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Assignee : AbstractUserField("assignee"), SortableField

object Creator : AbstractUserField("creator"), SortableField

object Reporter : AbstractUserField("reporter"), SortableField

object Voter : AbstractUserField("voter")

object Watcher : AbstractUserField("watcher")
