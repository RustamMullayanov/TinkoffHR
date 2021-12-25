package com.example.api.common.api.base

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class EnvelopeCallAdapter<T>(
    private val successType: Type,
) : CallAdapter<Envelope<T>, EnvelopeCall<T>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<Envelope<T>>): EnvelopeCall<T> {
        return EnvelopeCallImpl(call)
    }
}