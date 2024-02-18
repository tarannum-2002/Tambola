package org.example

class TambolaTicket(
    val firstRow: ArrayList<Int>,
    val secondRow: ArrayList<Int>,
    val lastRow: ArrayList<Int>,
) {

}

fun main() {

    val tambolaTicket = TambolaTicket(
        arrayListOf(4, 16, 48, 63, 76),
        arrayListOf(7, 23, 38, 52, 80),
        arrayListOf(9, 25, 56, 64, 83),
    )
    val claim = "Top Row"
    val numbersAnnounced = arrayListOf(90, 4, 46, 63, 89, 16, 76, 48)
    validateClaim(claim, tambolaTicket, numbersAnnounced)
}

fun validateClaim(
    claim: String,
    tambolaTicket: TambolaTicket,
    numbersAnnounced: ArrayList<Int>,
): Boolean {
    return when (claim) {
        "Top Row" -> {
            rowClaimValidator(tambolaTicket, numbersAnnounced, 0)
        }

        "Middle Row" -> {
            rowClaimValidator(tambolaTicket, numbersAnnounced, 1)
        }

        "Bottom Row" -> {
            rowClaimValidator(tambolaTicket, numbersAnnounced, 2)
        }

        "First Five" -> {
            firstNumberOfMatchesValidator(tambolaTicket, numbersAnnounced, 5)
        }

        "Full House" -> {
            firstNumberOfMatchesValidator(tambolaTicket, numbersAnnounced, 15)
        }

        else -> {
            false
        }
    }
}

fun rowClaimValidator(tambolaTicket: TambolaTicket, numbersAnnounced: ArrayList<Int>, rowIndex: Int): Boolean {
    var rowCounter = 0
    var claim = false
    var turn = 0
    if (markIfPresent(tambolaTicket, numbersAnnounced.last()) != rowIndex) return false
    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(tambolaTicket, num)
        if (result == rowIndex) {
            rowCounter++
        }
        if ((turn == numbersAnnounced.size) && rowCounter == 5) {
            claim = true
            break
        }
    }
    return claim
}

fun firstNumberOfMatchesValidator(
    tambolaTicket: TambolaTicket,
    numbersAnnounced: ArrayList<Int>,
    numberOfMatches: Int,
): Boolean {
    var counter = 0
    var claim = false
    var turn = 0
    if (markIfPresent(tambolaTicket, numbersAnnounced.last()) == -1) return false
    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(tambolaTicket, num)
        if (result != -1) {
            counter++
        }
        if ((turn == numbersAnnounced.size) && counter == numberOfMatches) {
            claim = true
        }
    }
    return claim
}

fun markIfPresent(tambolaTicket: TambolaTicket, num: Int): Int {
    return when (num) {
        in tambolaTicket.firstRow -> {
            0
        }

        in tambolaTicket.secondRow -> {
            1
        }

        in tambolaTicket.lastRow -> {
            2
        }

        else -> {
            -1
        }
    }

//    for ((listCounter, list) in tambolaTicket.withIndex()) {
//        for (block in list) {
//            if (block == num) {
//                return listCounter
//            }
//        }
//    }
//    return -1
}
