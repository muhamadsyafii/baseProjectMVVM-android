package com.syafii.data.persistences.mappers.basemapper

import com.syafii.data.payload.responses.BaseResponse
import com.syafii.domain.BaseResponseDomain

interface IBaseMapper<DATA> {
    fun toBaseResponseDomain(response: BaseResponse<DATA>): BaseResponseDomain
}