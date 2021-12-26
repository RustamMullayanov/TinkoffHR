package com.example.api.common.api.base

import com.example.api.common.api.exception.ServerInvalidResponseException
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*


@Serializer(forClass = Envelope::class)
class EnvelopeSerializer<T>(private val dataSerializer: KSerializer<T>) : KSerializer<Envelope<T>> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("EnvelopeSerializer") {
        buildJsonObject {
            element(DATA, dataSerializer.descriptor)
            element(ERROR_MESSAGE, String.serializer().descriptor)
        }
    }

    override fun deserialize(decoder: Decoder): Envelope<T> {
        require(decoder is JsonDecoder)
        val element = decoder.decodeJsonElement()
        require(element is JsonObject)

        val errorMessage = element[ERROR_MESSAGE]?.jsonPrimitive?.content
        try {
            return if (errorMessage == null) {
                parseOkResponse(decoder, element)
            } else {
                parseErrorResponse(decoder, element)
            }
        } catch (exception: SerializationException) {
            throw ServerInvalidResponseException(exception.message ?: "Invalid response")
        }
    }

    private fun parseErrorResponse(decoder: JsonDecoder, element: JsonObject): Envelope<T> {
        return Envelope(
            data = null,
            errorMessage = decoder.json.decodeFromJsonElement(element[ERROR_MESSAGE]!!),
        )
    }

    private fun parseOkResponse(decoder: JsonDecoder, element: JsonObject): Envelope<T> {
        return Envelope(
            data = decoder.json.decodeFromJsonElement(dataSerializer, element[DATA]!!),
            errorMessage = null
        )
    }

    override fun serialize(encoder: Encoder, value: Envelope<T>) {
        require(encoder is JsonEncoder)
        val element = buildJsonObject {
            if (value.data != null) {
                put(DATA, encoder.json.encodeToJsonElement(dataSerializer, value.data))
            }
            if (value.errorMessage != null) {
                put(
                    ERROR_MESSAGE,
                    encoder.json.encodeToJsonElement(String.serializer(), value.errorMessage)
                )
            }
        }
        encoder.encodeJsonElement(element)
    }

    private companion object {
        const val DATA = "data"
        const val ERROR_MESSAGE = "errorMessage"
    }
}