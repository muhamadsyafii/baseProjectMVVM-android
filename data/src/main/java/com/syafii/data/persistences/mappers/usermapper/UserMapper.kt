package com.syafii.data.persistences.mappers.usermapper

import com.syafii.data.payload.responses.BaseResponse
import com.syafii.data.payload.responses.UserResponse
import com.syafii.data.payload.responses.UserResponsePayload
import com.syafii.data.persistences.mappers.basemapper.IBaseMapper
import com.syafii.domain.BaseResponseDomain
import com.syafii.domain.UserDomain

class UserMapper(
    private val baseMapper: IBaseMapper<Any>
) : IUserMapper {
    override fun toUserDomain(response: UserResponsePayload): UserDomain {
        return if (response is UserResponse) {
            UserDomain(
                response.id ?: 0,
                response.firstName ?: "",
                response.lastName ?: "",
                response.email ?: "",
                response.avatar ?: ""
            )
        } else UserDomain()
    }

    override fun toListUserDomain(response: List<UserResponsePayload>): List<UserDomain> {
        return response.asSequence().map { toUserDomain(it) }.toList()
    }

    override fun toBaseUserDomain(response: BaseResponse<UserResponsePayload>): BaseResponseDomain {
        val baseResponse = baseMapper.toBaseResponseDomain(response as BaseResponse<Any>)
        baseResponse.data = toUserDomain(response.data ?: UserResponse())
        return baseResponse
    }

    override fun toListBaseUserDomain(response: BaseResponse<List<UserResponsePayload>>): BaseResponseDomain {
        val baseResponse = baseMapper.toBaseResponseDomain(response as BaseResponse<Any>)
        baseResponse.data =
            toListUserDomain(response.data ?: emptyList())
        return baseResponse
    }
}