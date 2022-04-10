package com.example.tinkoff_hr.ui.tribute.item

import com.example.tinkoff_hr.ui.tribute.data.Education


data class EducationItem(
    val list: List<Education>,
    override val id: String = "Education item"
) : BaseListItem