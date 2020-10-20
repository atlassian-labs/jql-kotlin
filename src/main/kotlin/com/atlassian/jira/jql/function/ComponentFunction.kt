package com.atlassian.jira.jql.function

import com.atlassian.jira.jql.escape

interface ComponentFunction : Function

fun componentsLeadByUser(user: String? = null): ComponentFunction =
    object : AbstractFunction("componentsLeadByUser", listOfNotNull(user).map { it.escape() }), ComponentFunction {}
