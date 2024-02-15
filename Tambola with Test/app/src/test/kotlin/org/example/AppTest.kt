/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.example

import kotlin.test.Test
import kotlin.test.assertTrue

class AppTest {
    @Test
    fun `should pass when gets Top rows announced`()
    {
        val numbersAnnounced = arrayListOf(90, 4, 46, 63, 89, 16, 76, 48)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertTrue(TopRowClaimValidator(ticket, numbersAnnounced))
    }
}
