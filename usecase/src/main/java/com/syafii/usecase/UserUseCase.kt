package com.syafii.usecase

import com.syafii.data.persistences.repositories.IUserRepository
import com.syafii.domain.BaseResponseDomain

class UserUseCase(
    private val repository: IUserRepository
) : IUserUseCase {
    override suspend fun getUsers(payload: Int): BaseResponseDomain =
        repository.getUsers(payload)

    override suspend fun getUserbyId(payload: Int): BaseResponseDomain =
        repository.getUserbyId(payload)
}