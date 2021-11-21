package com.example.tinkoff_hr.ui.faq.MeetUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityMeetUpBinding
import android.content.res.ColorStateList
import android.view.MenuItem


class MeetUpActivity : AppCompatActivity() {

    private val binging: ActivityMeetUpBinding by lazy {
        ActivityMeetUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.title = "Meetup`s"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val colorOpen = ColorStateList.valueOf(resources.getColor(R.color.pure_violet))

        val colorClose = ColorStateList.valueOf(resources.getColor(R.color.black))

        binging.apply {

            textWhatDoSpeaker.defaultHintTextColor = colorClose
            textListenerInformation.defaultHintTextColor = colorClose

            buttonWhatDoSpeaker.setOnClickListener {
                expandableWhatDoSpeaker.toggle()
                if (expandableWhatDoSpeaker.isExpanded) {
                    textWhatDoSpeaker.defaultHintTextColor = colorOpen
                    textWhatDoSpeaker.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_up_24)
                } else {
                    textWhatDoSpeaker.defaultHintTextColor = colorClose
                    textWhatDoSpeaker.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_down_24)
                }
            }

            buttonListenerInformation.setOnClickListener {
                expandableListenerInformation.toggle()
                if (expandableListenerInformation.isExpanded) {
                    textListenerInformation.defaultHintTextColor = colorOpen
                    textListenerInformation.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_up_24)
                } else {
                    textListenerInformation.defaultHintTextColor = colorClose
                    textListenerInformation.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_down_24)
                }
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