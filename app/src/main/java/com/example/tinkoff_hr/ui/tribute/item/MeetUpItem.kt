package com.example.tinkoff_hr.ui.tribute.item

import com.example.tinkoff_hr.ui.tribute.data.MeetUp
import com.example.tinkoff_hr.ui.tribute.data.MeetUpLarge

data class MeetUpItem(
    val largeMeetUp: MeetUpLarge,
    val smallMeetUpList: List<MeetUp>,
    override val id: String = "MeetUp Item"
) : BaseListItem