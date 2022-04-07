package com.example.tinkoff_hr.domain.entities.worker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
data class Worker(
    val id: String,
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String? = null,
    val photo: String? = null,
    val project: String,
    val table: String,
    val function: String,
    val about: String,
    val status: WorkerStatus
) : Parcelable