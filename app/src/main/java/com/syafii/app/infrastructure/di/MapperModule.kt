package com.syafii.app.infrastructure.di

import com.syafii.data.persistences.mappers.basemapper.BaseMapper
import com.syafii.data.persistences.mappers.basemapper.IBaseMapper
import com.syafii.data.persistences.mappers.usermapper.IUserMapper
import com.syafii.data.persistences.mappers.usermapper.UserMapper
import org.koin.dsl.module

val mapperModules = module {

    single<IBaseMapper<Any>> { BaseMapper() }
    single<IUserMapper> { UserMapper(get()) }

}

