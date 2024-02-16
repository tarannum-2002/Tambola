/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.example

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AppTest {
    @Test
    fun `should return the correct index of row that contains the input number `()
    {
        val numbersAnnounced = 4
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertEquals(0,markIfPresent(ticket, numbersAnnounced))

    }

    @Test
    fun `should return negative one if ticket does not contains the input `()
    {
        val numbersAnnounced = 20
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertEquals(-1,markIfPresent(ticket, numbersAnnounced))

    }
    @Test
    fun `should return true when correct top row claim is made`()
    {
        val numbersAnnounced = arrayListOf(9, 4, 16, 63, 48, 76)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertTrue(topRowClaimValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return true when correct bottom row claim is made`()
    {
        val numbersAnnounced = arrayListOf(9, 25, 56, 64, 48, 83)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertTrue(bottomRowClaimValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return false when incorrect top row claim is made`()
    {
        val numbersAnnounced = arrayListOf(9, 4, 16, 63, 48, 76,23)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertFalse(topRowClaimValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return false when incorrect bottom row claim is made`()
    {
        val numbersAnnounced = arrayListOf(9, 25, 56, 64, 48, 83,12)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertFalse(bottomRowClaimValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return true for correct early five numbers claimed`()
    {
        val numbersAnnounced = arrayListOf(7, 25, 56, 64, 41, 83)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertTrue(firstFiveValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return false for incorrect early five numbers claimed`()
    {
        val numbersAnnounced = arrayListOf(7, 25, 56, 64, 41, 83, 76)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertFalse(firstFiveValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return false for incorrect early five numbers claimed late`()
    {
        val numbersAnnounced = arrayListOf(7, 25, 56, 64, 41, 83, 77)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertFalse(firstFiveValidator(ticket, numbersAnnounced))

    }

    @Test
    fun `should return true for any valid claimed`()
    {
        val numbersAnnounced = arrayListOf(7, 25, 56, 64, 41, 83, 77)
        val ticket = arrayListOf(
            arrayListOf(4,16,48,63,76),
            arrayListOf(7,23,38,52,80),
            arrayListOf(9,25,56,64,83)
        )
        assertFalse(validateClaim("Top Row",ticket, numbersAnnounced))

    }
}
