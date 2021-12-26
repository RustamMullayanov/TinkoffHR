package com.example.api.common.api.exception

class ServerHttpException(
    private val errorCode: Int,
    private val errorMessage: String,
    private val errorBody: String?
) : ServerException() {

    override fun buildErrorMessage(): String {
        return "$errorCode - $errorMessage${if (errorBody != null) "\n$errorBody" else ""}"
    }
}