package com.syafii.data.persistences.contracts

import com.syafii.data.payload.responses.BaseResponse
import com.syafii.data.payload.responses.UserResponse
import com.syafii.data.service.remote.UserService

class UserPersistence(
    private val service: UserService
) : IUserPersistence {
    override suspend fun getUsers(payload: Int): BaseResponse<List<UserResponse>> =
        service.getUsers(payload)

    override suspend fun getUserbyId(payload: Int): BaseResponse<UserResponse> =
        service.getUserbyId(payload)

}