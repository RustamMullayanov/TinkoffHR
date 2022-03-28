package com.example.api.common.api.exception

class ServerInvalidResponseException(private val errorMessage: String) : ServerException() {

    override fun buildErrorMessage(): String = errorMessage
}