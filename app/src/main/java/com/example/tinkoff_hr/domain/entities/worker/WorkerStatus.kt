package com.example.tinkoff_hr.domain.entities.worker

enum class WorkerStatus(val value: Boolean) {

    ACTIVE(true),

    INACTIVE(false);

    companion object {
        fun fromValue(value: Boolean) =
            values().find { it.value == value } ?: throw IllegalStateException()
    }
}