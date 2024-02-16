package org.example

fun main() {
    val ticket = arrayListOf(
        arrayListOf(4, 16, Int.MAX_VALUE, Int.MAX_VALUE, 48, Int.MAX_VALUE, 63, 76, Int.MAX_VALUE),
        arrayListOf(7, Int.MAX_VALUE, 23, 38, Int.MAX_VALUE, 52, Int.MAX_VALUE, Int.MAX_VALUE, 80),
        arrayListOf(9, Int.MAX_VALUE, 25, Int.MAX_VALUE, Int.MAX_VALUE, 56, 64, Int.MAX_VALUE, 83)
    )

    val claim = "Top Row"


    val filteredList = ticket.map { sublist ->
        sublist.filter { it != Int.MAX_VALUE }
    }

    val numbersAnnounced = arrayListOf(90, 4, 46, 63, 89, 16, 76, 48)

    if (claim == "Top Row") {
        if (topRowClaimValidator(filteredList, numbersAnnounced)) println("claim accepted")
        else println("claim rejected")
    } else if (claim == "Bottom Row") {
        if (bottomRowClaimValidator(filteredList, numbersAnnounced)) println("claim accepted")
        else println("claim rejected")
    } else {
        if (firstFiveValidator(filteredList, numbersAnnounced)) println("claim accepted")
        else println("claim rejected")
    }


}

fun topRowClaimValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>): Boolean {
    var firstRowCounter = 0

    var claimSupposedToBeAnnounced = false
    var claim = false
    var turn = 0

    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(ticket, num)
        if (result != -1 && result == 0) {
            firstRowCounter++

        }

        if ((turn != numbersAnnounced.size) && firstRowCounter == 5) {
            claimSupposedToBeAnnounced = true
        }

    }

    if (firstRowCounter == 5) {
        claim = true
    }

    if (!claimSupposedToBeAnnounced && claim) {
        return true
    }
    return false

}

fun bottomRowClaimValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>): Boolean {


    var thirdRowCounter = 0
    var claimSupposedToBeAnnounced = false
    var claim = false
    var turn = 0

    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(ticket, num)
        if (result != -1 && result == 2) {
            thirdRowCounter++
        }

        if ((turn != numbersAnnounced.size) && thirdRowCounter == 5) {
            claimSupposedToBeAnnounced = true
        }

    }

    if (thirdRowCounter == 5) {
        claim = true
    }

    if (!claimSupposedToBeAnnounced && claim) {
        return true
    }
    return false

}

fun firstFiveValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>): Boolean {
    var counter = 0

    var claimSupposedToBeAnnounced = false
    var claim = false
    var turn = 0

    for (num in numbersAnnounced) {
        turn++
        val result = markIfPresent(ticket, num)
        if (result != -1) {
            if (result == 0) counter++

        }

        if ((turn != numbersAnnounced.size) && counter == 5) {
            claimSupposedToBeAnnounced = true
        }

    }

    if (counter == 5) {
        claim = true
    }

    if (!claimSupposedToBeAnnounced && claim) {
        return true
    }
    return false

}

fun markIfPresent(ticket: List<List<Int>>, num: Int): Int {
    for (list in ticket) {
        for ((listCounter, block) in list.withIndex()) {
            if (block == num) {
                return listCounter
            }
        }
    }
    return -1

}
