package com.syafii.data.persistences.contracts

import com.syafii.data.payload.responses.BaseResponse
import com.syafii.data.payload.responses.UserResponse

interface IUserPersistence {
    suspend fun getUsers(payload : Int) : BaseResponse<List<UserResponse>>
    suspend fun getUserbyId(payload : Int) : BaseResponse<UserResponse>
}