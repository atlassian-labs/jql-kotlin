package com.atlassian.jira.jql

import java.util.Locale

enum class Keyword : JqlEntity {
    AND, OR;

    override fun toJql(): String = name.uppercase(Locale.ENGLISH)
}
