package com.example.api.common.api.exception

abstract class ServerException() : Exception() {

    override val message: String by lazy { buildErrorMessage() }

    abstract fun buildErrorMessage(): String
}