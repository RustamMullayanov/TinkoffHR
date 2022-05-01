package com.example.tinkoff_hr.domain.entities.worker

import android.os.Parcelable
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WorkerItem(
    override val id: String,
    val email: String,
    val name: String,
    val surname: String,
    val patronymic: String? = null,
    val photo: String? = null,
    val project: String,
    val table: String,
    val function: String,
    val about: String,
    val status: WorkerStatus,
    val state_id: String,
    val permission_id: String
) : BaseListItem, Parcelable
