package com.syafii.usecase

import com.syafii.domain.BaseResponseDomain

interface IUserUseCase {
    suspend fun getUsers(payload: Int): BaseResponseDomain
    suspend fun getUserbyId(payload: Int): BaseResponseDomain
}