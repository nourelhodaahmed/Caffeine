package com.android.caffeine.ui.screen.coffeedetails.utils

import com.android.caffeine.model.CaffeineSize
import com.android.caffeine.model.CupSize

fun caffeieneSizeToIndex(caffeineSize: CaffeineSize):Int{
    return when(caffeineSize){
        CaffeineSize.LOW -> 0
        CaffeineSize.MEDIUM -> 1
        CaffeineSize.HIGH -> 2
    }
}

fun indexToCaffeieneSize(index: Int): CaffeineSize{
    return when(index){
        0 -> CaffeineSize.LOW
        1 -> CaffeineSize.MEDIUM
        2 -> CaffeineSize.HIGH
        else -> CaffeineSize.LOW
    }
}

fun cupSizeToIndex(cupSize: CupSize):Int{
    return when(cupSize){
        CupSize.S -> 0
        CupSize.M -> 1
        CupSize.L -> 2
    }
}

fun indexToCupSize(index: Int): CupSize{
    return when(index){
        0 -> CupSize.S
        1 -> CupSize.M
        2 -> CupSize.L
        else -> CupSize.S
    }
}