package com.syafii.data.persistences.repositories

import com.syafii.domain.BaseResponseDomain

interface IUserRepository {
    suspend fun getUsers(payload: Int): BaseResponseDomain
    suspend fun getUserbyId(payload: Int): BaseResponseDomain
}