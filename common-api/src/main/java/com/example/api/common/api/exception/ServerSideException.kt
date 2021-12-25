package com.example.api.common.api.exception

class ServerSideException(private val errorBody: String) : ServerException() {

    override fun buildErrorMessage(): String = errorBody
}