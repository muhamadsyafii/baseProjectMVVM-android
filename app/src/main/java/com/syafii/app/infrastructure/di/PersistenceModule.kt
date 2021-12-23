package com.syafii.app.infrastructure.di

import com.syafii.data.persistences.contracts.IUserPersistence
import com.syafii.data.persistences.contracts.UserPersistence
import org.koin.dsl.module

val persistenceModules = module {
    single<IUserPersistence> { UserPersistence(get()) }
}