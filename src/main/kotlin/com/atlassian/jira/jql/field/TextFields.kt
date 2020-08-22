package com.atlassian.jira.jql.field

import com.atlassian.jira.jql.Clause
import com.atlassian.jira.jql.escape

abstract class AbstractTextField(name: String) : Field(name) {
    infix fun contains(value: String) = contains { value.escape() }
}

abstract class AbstractNegativeMatchTextField(name: String) : AbstractTextField(name) {
    infix fun doesNotContain(value: String) = doesNotContain { value.escape() }
}

abstract class AbstractOptionalTextField(name: String) : AbstractNegativeMatchTextField(name) {
    infix fun iz(value: IsIsNotValue): Clause = iz { value }
    infix fun izNot(value: IsIsNotValue): Clause = izNot { value }
}

object Comment : AbstractNegativeMatchTextField("comment")

object Description : AbstractOptionalTextField("description"), SortableField

object Environment : AbstractOptionalTextField("environment"), SortableField

object Summary : AbstractOptionalTextField("summary"), SortableField

object Text : AbstractTextField("text")
