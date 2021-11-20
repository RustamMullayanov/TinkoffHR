package com.example.tinkoff_hr.ui.faq.MeetUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tinkoff_hr.databinding.ActivityMeetUpBinding

class MeetUpActivity : AppCompatActivity() {

    private val binging: ActivityMeetUpBinding by lazy { ActivityMeetUpBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)
    }
}