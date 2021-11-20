package com.example.tinkoff_hr.ui.faq.MeetUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityMeetUpBinding
import android.content.res.ColorStateList
import android.view.MenuItem


class MeetUpActivity : AppCompatActivity() {

    private val binging: ActivityMeetUpBinding by lazy {
        ActivityMeetUpBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.title = "Meetup`s"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val colorOpen = ColorStateList(
            arrayOf(intArrayOf(-android.R.attr.state_focused)),
            intArrayOf(R.color.pure_violet)
        )

        val colorClose = ColorStateList(
            arrayOf(intArrayOf(-android.R.attr.state_focused)),
            intArrayOf(R.color.black)
        )

        binging.apply {

            buttonWhatDoSpeaker.setOnClickListener {
                expandableWhatDoSpeaker.toggle()
                if (expandableWhatDoSpeaker.isExpanded) {
                    textWhatDoSpeaker.defaultHintTextColor = colorOpen
                } else
                    textWhatDoSpeaker.defaultHintTextColor = colorClose
            }

            buttonListenerInformation.setOnClickListener {
                expandableListenerInformation.toggle()
                if (expandableListenerInformation.isExpanded) {
                    textListenerInformation.defaultHintTextColor = colorOpen
                } else
                    textListenerInformation.defaultHintTextColor = colorClose
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}