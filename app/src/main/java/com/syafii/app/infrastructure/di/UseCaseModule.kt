package com.syafii.app.infrastructure.di

import com.syafii.usecase.IUserUseCase
import com.syafii.usecase.UserUseCase
import org.koin.dsl.module

val useCaseModules = module {
    single<IUserUseCase> { UserUseCase(get()) }
}