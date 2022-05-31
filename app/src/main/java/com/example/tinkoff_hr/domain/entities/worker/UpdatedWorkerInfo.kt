package com.example.tinkoff_hr.domain.entities.worker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpdatedWorkerInfo(
    val about: String,
    val function: String,
    val project: String,
) : Parcelable
