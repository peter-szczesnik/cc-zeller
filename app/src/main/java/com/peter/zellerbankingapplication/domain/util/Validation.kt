package com.peter.zellerbankingapplication.domain.util

fun isAmountValid(amtStr: String) : Boolean {
    if(amtStr == "") return true
    return try {
        val amt = amtStr.toDouble()
        amt != 0.0
    } catch (ex: Exception) {
        false
    }
}

fun getAmount(amtStr: String) : Double {
    if(amtStr == "") return 0.0
     try {
        return amtStr.toDouble()
    } catch (ex: Exception) {
        return return 0.0
    }

}