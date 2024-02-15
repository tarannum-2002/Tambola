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

fun TopRowClaimValidator(ticket: ArrayList<ArrayList<Int>>, numbersAnnounced: ArrayList<Int>) : Boolean{
    var firstRowCounter = 0
    var secRowCounter = 0
    var thirdRowCounter = 0
    var ClaimSupposedToBeAnnounced = false
    var Claim = false
    var turn =0;

    for (num in numbersAnnounced){
        turn++
        val result = markIfPresent(ticket, num)
        if(result!=-1){
            if(result==0) firstRowCounter++;
            else if (result==1) secRowCounter++;
            else if(result==2) thirdRowCounter++
        }

        if((turn!=numbersAnnounced.size-1) && (firstRowCounter==5 || secRowCounter==5 || thirdRowCounter== 5)){
            ClaimSupposedToBeAnnounced=true
        }

    }

    if(firstRowCounter==5 || secRowCounter==5 || thirdRowCounter== 5){
        Claim=true
    }

    if(ClaimSupposedToBeAnnounced==false && Claim==true ){
        return true
    }
    return false

}

fun markIfPresent(ticket: ArrayList<ArrayList<Int>>, num: Int): Int {
    for (list in ticket){
        var listCounter=0
        for (block in list){
            if(block==num){
                return listCounter
            }
        }
        listCounter++
    }
    return -1

}
