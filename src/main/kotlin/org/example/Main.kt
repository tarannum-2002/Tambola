package org.example.org.example

fun main() {
    val ticket = arrayListOf(
        arrayListOf(4,16, Int.MAX_VALUE, Int.MAX_VALUE,48,Int.MAX_VALUE,63,76,Int.MAX_VALUE),
        arrayListOf(7, Int.MAX_VALUE,23,38, Int.MAX_VALUE,52,Int.MAX_VALUE, Int.MAX_VALUE,80),
        arrayListOf(9, Int.MAX_VALUE,25,Int.MAX_VALUE, Int.MAX_VALUE, 56,64,  Int.MAX_VALUE, 83 )
    )

    val claim = "Top Row"


    val filteredList = ticket.map { sublist ->
        sublist.filter { it != Int.MAX_VALUE }
    }

    val numbersAnnounced = arrayListOf(90, 4, 46, 63, 89, 16, 76, 48)

    if(claim=="Top Row"){
        if(TopRowClaimValidator(filteredList, numbersAnnounced)) println("claim accepted")
        else println("claim rejected")
    }
    else if(claim=="Bottom Row"){
        if(BottomRowClaimValidator(filteredList, numbersAnnounced)) println("claim accepted")
        else println("claim rejected")
    }
    else{
        if(FirstFiveValidator(filteredList, numbersAnnounced)) println("claim accepted")
        else println("claim rejected")
    }




}

fun TopRowClaimValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>) : Boolean{
    var firstRowCounter = 0

    var ClaimSupposedToBeAnnounced = false
    var Claim = false
    var turn =0;

    for (num in numbersAnnounced){
        turn++
        val result = markIfPresent(ticket, num)
        if(result!=-1 && result ==0 ){
            firstRowCounter++;

        }

        if((turn!=numbersAnnounced.size) && firstRowCounter==5){
            ClaimSupposedToBeAnnounced=true
        }

    }

    if(firstRowCounter==5 ){
        Claim=true
    }

    if(ClaimSupposedToBeAnnounced==false && Claim==true ){
        return true
    }
    return false

}

fun BottomRowClaimValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>) : Boolean{


    var thirdRowCounter = 0
    var ClaimSupposedToBeAnnounced = false
    var Claim = false
    var turn =0;

    for (num in numbersAnnounced){
        turn++
        val result = markIfPresent(ticket, num)
        if(result!=-1 && result==2){
            thirdRowCounter++
        }

        if((turn!=numbersAnnounced.size) &&  thirdRowCounter== 5){
            ClaimSupposedToBeAnnounced=true
        }

    }

    if(thirdRowCounter== 5){
        Claim=true
    }

    if(ClaimSupposedToBeAnnounced==false && Claim==true ){
        return true
    }
    return false

}

fun FirstFiveValidator(ticket: List<List<Int>>, numbersAnnounced: ArrayList<Int>) : Boolean{
    var Counter = 0

    var ClaimSupposedToBeAnnounced = false
    var Claim = false
    var turn =0;

    for (num in numbersAnnounced){
        turn++
        val result = markIfPresent(ticket, num)
        if(result!=-1){
            if(result==0) Counter++;

        }

        if((turn!=numbersAnnounced.size) && Counter==5 ){
            ClaimSupposedToBeAnnounced=true
        }

    }

    if(Counter==5){
        Claim=true
    }

    if(ClaimSupposedToBeAnnounced==false && Claim==true ){
        return true
    }
    return false

}

fun markIfPresent(ticket: List<List<Int>>, num: Int): Int {
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
