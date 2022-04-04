package com.example.tinkoff_hr.domain.entities.worker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpdatedWorkerInfo(
    val id: Int,
    val about: String,
    val function: String,
    val project: Int,
    val status: WorkerStatus,
    val table: Int,
): Parcelable
