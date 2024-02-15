package org.example

fun main() {
    val ticket = arrayListOf(
        arrayListOf(4,16, Int.MAX_VALUE, Int.MAX_VALUE,48,Int.MAX_VALUE,63,76,Int.MAX_VALUE),
        arrayListOf(7, Int.MAX_VALUE,23,38, Int.MAX_VALUE,52,Int.MAX_VALUE, Int.MAX_VALUE,80),
        arrayListOf(9, Int.MAX_VALUE,25,Int.MAX_VALUE, Int.MAX_VALUE, 56,64,  Int.MAX_VALUE, 83 )
    )

    val claim = "Top Row"

    val numbersAnnounced = arrayListOf(90, 4, 46, 63, 89, 16, 76, 48, 12 )

    TopRowClaimValidator(ticket, numbersAnnounced)


}

fun TopRowClaimValidator(ticket: ArrayList<ArrayList<Int>>, numbersAnnounced: ArrayList<Int>) {
    val firstRowCounter = 0
    val secRowCounter = 0
    val thirdRowCounter = 0

    for (num in numbersAnnounced){
        if(markIfPresent(ticket, num)){

        }
    }

}

fun markIfPresent(ticket: ArrayList<ArrayList<Int>>, num: Int): Boolean {
    for (list in ticket){
        for (block in list){
            if(block==num){
                return true
            }
        }
    }

}
