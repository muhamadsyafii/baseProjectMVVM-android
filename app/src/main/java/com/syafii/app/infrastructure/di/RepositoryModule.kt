package com.syafii.app.infrastructure.di

import com.syafii.data.persistences.repositories.IUserRepository
import com.syafii.data.persistences.repositories.UserRepository
import org.koin.dsl.module

val repositoryModules = module {

    single<IUserRepository> { UserRepository(get(),get()) }

}