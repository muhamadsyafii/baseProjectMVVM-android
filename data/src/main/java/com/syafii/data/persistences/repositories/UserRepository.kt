package com.syafii.data.persistences.repositories

import com.syafii.data.payload.responses.BaseResponse
import com.syafii.data.payload.responses.UserResponsePayload
import com.syafii.data.persistences.contracts.IUserPersistence
import com.syafii.data.persistences.mappers.usermapper.IUserMapper
import com.syafii.domain.BaseResponseDomain

class UserRepository(
    private val persistence : IUserPersistence,
    private val userMapper : IUserMapper
) : IUserRepository {
    override suspend fun getUsers(payload: Int): BaseResponseDomain {
        val persistenceImpl = persistence.getUsers(payload)
        return userMapper.toListBaseUserDomain(persistenceImpl as BaseResponse<List<UserResponsePayload>>)
    }

    override suspend fun getUserbyId(payload: Int): BaseResponseDomain {
        val persistenceImpl = persistence.getUserbyId(payload)
        return userMapper.toBaseUserDomain(persistenceImpl as BaseResponse<UserResponsePayload>)
    }
}