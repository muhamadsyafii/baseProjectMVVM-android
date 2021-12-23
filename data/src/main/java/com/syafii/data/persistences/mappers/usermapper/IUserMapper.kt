package com.syafii.data.persistences.mappers.usermapper

import com.syafii.data.payload.responses.BaseResponse
import com.syafii.data.payload.responses.UserResponsePayload
import com.syafii.domain.BaseResponseDomain
import com.syafii.domain.UserDomain

interface IUserMapper {

    fun toUserDomain(response : UserResponsePayload) : UserDomain
    fun toListUserDomain(response: List<UserResponsePayload>) : List<UserDomain>

    fun toBaseUserDomain(response: BaseResponse<UserResponsePayload>) : BaseResponseDomain
    fun toListBaseUserDomain(response: BaseResponse<List<UserResponsePayload>>) : BaseResponseDomain

}