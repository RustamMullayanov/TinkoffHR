package com.example.tinkoff_hr.data.api

import com.example.api.common.api.base.EnvelopeCall
import com.example.tinkoff_hr.data.entities.authentication.EmailEntityForApi
import com.example.tinkoff_hr.data.entities.authentication.TokenEntityForApi
import com.example.tinkoff_hr.data.entities.authentication.VerifyUserEntityForApi
import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitServiceAuthentication {

    @POST("/auth/detect-user")
    fun checkUserEmail(@Body email: EmailEntityForApi): EnvelopeCall<Unit>

    @POST("/auth/send-code")
    fun sendCodeToEmail(@Body email: EmailEntityForApi): EnvelopeCall<Unit>

    @POST("/auth/verify")
    fun verifyUser(
        @Header("Auth-Type") authType: String = "Mobile",
        @Body verifyUser: VerifyUserEntityForApi
    ): EnvelopeCall<TokenEntityForApi>

    @POST("/auth/register")
    fun userRegistration(
        @Header("Token") token: String,
        @Body updatedWorkerInfo: UpdatedWorkerInfo
    ): EnvelopeCall<Unit>
}