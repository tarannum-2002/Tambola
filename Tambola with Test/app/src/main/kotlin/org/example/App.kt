package org.example

fun main() {
    val ticket = arrayListOf(
        arrayListOf(4, 16, 48, 63, 76),
        arrayListOf(7, 23, 38, 52, 80),
        arrayListOf(9, 25, 56, 64, 83)
    )
    val claim = "Top Row"
    val numbersAnnounced = arrayListOf(90, 4, 46, 63, 89, 16, 76, 48)
    validateClaim(claim, ticket, numbersAnnounced)
}

fun validateClaim(
    claim: String,
    ticket: ArrayList<ArrayList<Int>>,
    numbersAnnounced: ArrayList<Int>
):Boolean {
    return when (claim) {
        "Top Row"-> {
            rowClaimValidator(ticket, numbersAnnounced, 0)
        }
        "Bottom Row" -> {
            rowClaimValidator(ticket, numbersAnnounced, 2)
        }
        else -> {
            firstFiveValidator(ticket, numbersAnnounced)
        }
    }
}

fun rowClaimValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>,rowIndex :Int): Boolean {
    var firstRowCounter = 0
    var claim = false
    var turn = 0
    if (markIfPresent(ticket, numbersAnnounced.last()) != rowIndex) return false
    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(ticket, num)
        if (result == rowIndex) {
            firstRowCounter++
        }
        if ((turn == numbersAnnounced.size) && firstRowCounter == 5) {
            claim = true
            break
        }
    }
    return claim
}

fun firstFiveValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>): Boolean {
    var counter = 0
    var claim = false
    var turn = 0
    if (markIfPresent(ticket, numbersAnnounced.last()) == -1) return false
    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(ticket, num)
        if (result != -1) {
            counter++
        }

        if ((turn == numbersAnnounced.size) && counter == 5) {
            claim = true
        }

    }
    return claim
}
fun markIfPresent(ticket: List<List<Int>>, num: Int): Int {
    for ((listCounter, list) in ticket.withIndex()) {
        for (block in list) {
            if (block == num) {
                return listCounter
            }
        }
    }
    return -1
}
