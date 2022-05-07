package com.example.tinkoff_hr.ui.workers

import android.os.Parcelable
import com.example.tinkoff_hr.ui.tribute.item.BaseListItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WorkerItem(
    override val id: String,
    val name: String,
    val surname: String,
    val patronymic: String? = null,
    val photo: String? = null,
    val project: String,
    val function: String,
) : BaseListItem, Parcelable
