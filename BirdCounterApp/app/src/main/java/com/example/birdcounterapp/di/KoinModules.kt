package com.example.birdcounterapp.di

import com.example.birdcounterapp.model.BirdCounter
import com.example.birdcounterapp.ui.animalcounting.viewmodels.BirdCounterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory<BirdCounter> { BirdCounter() }
}

val viewModelModule = module {
    viewModel<BirdCounterViewModel> { BirdCounterViewModel(get()) }
}