package com.example.tinkoff_hr.data.api

import com.example.api.common.api.base.EnvelopeCall
import com.example.tinkoff_hr.data.entities.UpdatedWorkerInfoForApi
import com.example.tinkoff_hr.data.entities.authentication.EmailEntityForApi
import com.example.tinkoff_hr.data.entities.authentication.TokenEntityForApi
import com.example.tinkoff_hr.data.entities.authentication.VerifyUserEntityForApi
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitServiceAuthentication {

    @POST("/api/auth/detect-user")
    fun checkUserEmail(@Body email: EmailEntityForApi): EnvelopeCall<Unit>

    @POST("/api/auth/send-code")
    fun sendCodeToEmail(@Body email: EmailEntityForApi): EnvelopeCall<Unit>

    @POST("/api/auth/verify")
    fun verifyUser(
        @Header("Auth-Type") authType: String = "Mobile",
        @Body verifyUser: VerifyUserEntityForApi
    ): EnvelopeCall<TokenEntityForApi>

    @POST("/api/auth/register")
    fun userRegistration(
        @Header("Authorization") token: String,
        @Body updatedWorkerInfo: UpdatedWorkerInfoForApi
    ): EnvelopeCall<Unit>
}