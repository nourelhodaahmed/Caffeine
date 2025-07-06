package com.android.caffeine.di

import com.android.caffeine.ui.screen.coffeedetails.CoffeeDetailsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val viewModelModule = module {
    viewModelOf(::CoffeeDetailsViewModel)
}