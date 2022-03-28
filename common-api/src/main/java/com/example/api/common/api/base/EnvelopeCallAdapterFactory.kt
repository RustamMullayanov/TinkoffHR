package com.example.api.common.api.base

import com.google.gson.reflect.TypeToken
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class EnvelopeCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        // response must be wrapped exactly to EnvelopeCall
        if (EnvelopeCall::class.java != getRawType(returnType)) {
            return null
        }

        // check first that the return type is `ParameterizedType`
        check(returnType is ParameterizedType) {
            "return type must be parameterized as EnvelopeCall<Foo> or EnvelopeCall<out Foo>"
        }

        // get the response type inside the `EnvelopeCall` type
        val responseType = getParameterUpperBound(0, returnType)

        // wrap response type to Envelope<Type>
        val successBodyType = TypeToken.getParameterized(Envelope::class.java, responseType).type

        return EnvelopeCallAdapter<Any>(successBodyType)
    }
}