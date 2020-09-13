package com.atlassian.jira.jql.time

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class RelativeTimeTest {

    class RelativeTimeTestArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> = Stream.of(
            arguments(1.weeks.ago, "\"-1w\""),
            arguments(1.weeks.fromNow, "\"1w\""),
            arguments(2.days.ago, "\"-2d\""),
            arguments(2.days.fromNow, "\"2d\""),
            arguments(3.hours.ago, "\"-3h\""),
            arguments(3.hours.fromNow, "\"3h\""),
            arguments(4.minutes.ago, "\"-4m\""),
            arguments(4.minutes.fromNow, "\"4m\""),
            arguments((1.weeks + 2.days).ago, "\"-1w 2d\""),
            arguments((1.weeks + 2.days).fromNow, "\"1w 2d\""),
            arguments((1.weeks + 3.hours).ago, "\"-1w 3h\""),
            arguments((1.weeks + 3.hours).fromNow, "\"1w 3h\""),
            arguments((1.weeks + 4.minutes).ago, "\"-1w 4m\""),
            arguments((1.weeks + 4.minutes).fromNow, "\"1w 4m\""),
            arguments((2.days + 3.hours).ago, "\"-2d 3h\""),
            arguments((2.days + 3.hours).fromNow, "\"2d 3h\""),
            arguments((2.days + 4.minutes).ago, "\"-2d 4m\""),
            arguments((2.days + 4.minutes).fromNow, "\"2d 4m\""),
            arguments((3.hours + 4.minutes).ago, "\"-3h 4m\""),
            arguments((3.hours + 4.minutes).fromNow, "\"3h 4m\""),
            arguments((1.weeks + 2.days + 3.hours).ago, "\"-1w 2d 3h\""),
            arguments((1.weeks + 2.days + 3.hours).fromNow, "\"1w 2d 3h\""),
            arguments((1.weeks + 2.days + 4.minutes).ago, "\"-1w 2d 4m\""),
            arguments((1.weeks + 2.days + 4.minutes).fromNow, "\"1w 2d 4m\""),
            arguments((1.weeks + 3.hours + 4.minutes).ago, "\"-1w 3h 4m\""),
            arguments((1.weeks + 3.hours + 4.minutes).fromNow, "\"1w 3h 4m\""),
            arguments((2.days + 3.hours + 4.minutes).ago, "\"-2d 3h 4m\""),
            arguments((2.days + 3.hours + 4.minutes).fromNow, "\"2d 3h 4m\""),
            arguments((1.weeks + 2.days + 3.hours + 4.minutes).ago, "\"-1w 2d 3h 4m\""),
            arguments((1.weeks + 2.days + 3.hours + 4.minutes).fromNow, "\"1w 2d 3h 4m\""),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(RelativeTimeTestArguments::class)
    fun `relative time generates correct JQL`(relativeDateTime: RelativeDateTime, expectedJql: String) =
        assertJql(relativeDateTime.jql, expectedJql)
}
