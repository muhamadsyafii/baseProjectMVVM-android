package com.syafii.app.infrastructure.di

import com.syafii.app.ui.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { UserViewModel(get(), get()) }
}