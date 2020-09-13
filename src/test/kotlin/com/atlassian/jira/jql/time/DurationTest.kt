package com.atlassian.jira.jql.time

import com.atlassian.jira.jql.assertJql
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class DurationTest {

    class DurationTestArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> = Stream.of(
            arguments(1.w, "\"1w\""),
            arguments(2.d, "\"2d\""),
            arguments(3.h, "\"3h\""),
            arguments(4.m, "\"4m\""),
            arguments(1.weeks, "\"1w\""),
            arguments(2.days, "\"2d\""),
            arguments(3.hours, "\"3h\""),
            arguments(4.minutes, "\"4m\""),
            arguments(1.weeks + 2.days, "\"1w 2d\""),
            arguments(1.weeks + 3.hours, "\"1w 3h\""),
            arguments(1.weeks + 4.minutes, "\"1w 4m\""),
            arguments(2.days + 3.hours, "\"2d 3h\""),
            arguments(2.days + 4.minutes, "\"2d 4m\""),
            arguments(3.hours + 4.minutes, "\"3h 4m\""),
            arguments(1.weeks + 2.days + 3.hours, "\"1w 2d 3h\""),
            arguments(1.weeks + 2.days + 4.minutes, "\"1w 2d 4m\""),
            arguments(1.weeks + 3.hours + 4.minutes, "\"1w 3h 4m\""),
            arguments(2.days + 3.hours + 4.minutes, "\"2d 3h 4m\""),
            arguments(1.weeks + 2.days + 3.hours + 4.minutes, "\"1w 2d 3h 4m\"")
        )
    }

    @ParameterizedTest
    @ArgumentsSource(DurationTestArguments::class)
    fun `duration generates correct JQL`(duration: Duration, expectedJql: String) =
        assertJql(duration.jql, expectedJql)

    @Test
    fun `duration can't be negative`() {
        assertThrows<IllegalArgumentException> { (-1).weeks }
        assertThrows<IllegalArgumentException> { (-1).days }
        assertThrows<IllegalArgumentException> { (-1).hours }
        assertThrows<IllegalArgumentException> { (-1).minutes }
    }
}
