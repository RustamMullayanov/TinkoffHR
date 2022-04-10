package com.example.tinkoff_hr.ui.tribute.item

import com.example.tinkoff_hr.ui.tribute.data.Education
import com.example.tinkoff_hr.ui.tribute.data.EducationLarge


data class EducationItem(
    val largeEdu: EducationLarge,
    val smallEduList: List<Education>,
    override val id: String = "Education item"
) : BaseListItem