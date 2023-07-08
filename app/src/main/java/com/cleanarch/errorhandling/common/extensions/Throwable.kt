package com.cleanarch.errorhandling.common.extensions

import com.cleanarch.errorhandling.common.ErrorCodes
import com.cleanarch.errorhandling.common.ErrorType
import retrofit2.HttpException
import java.io.IOError
import java.io.IOException

fun Throwable.toErrorType(): ErrorType {

    return when (this) {
        is IOException -> ErrorType.Api.Network
        is HttpException -> when (this.code()) {
            ErrorCodes.Http.ResourceNotFound -> ErrorType.Api.NotFound
            ErrorCodes.Http.InternalServer -> ErrorType.Api.Server
            ErrorCodes.Http.ServiceUnavailable -> ErrorType.Api.ServiceUnavailable
            else -> ErrorType.Unknown
        }
        else -> ErrorType.Unknown
    }

}