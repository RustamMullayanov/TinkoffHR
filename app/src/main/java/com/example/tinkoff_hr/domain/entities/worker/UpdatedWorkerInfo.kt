package com.example.tinkoff_hr.domain.entities.worker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpdatedWorkerInfo(
    val id: String,
    val about: String,
    val function: String,
    val project: String,
    val status: WorkerStatus = WorkerStatus.ACTIVE,
    val table: String,
    val state_id: String,
    val permission_id: String
): Parcelable
