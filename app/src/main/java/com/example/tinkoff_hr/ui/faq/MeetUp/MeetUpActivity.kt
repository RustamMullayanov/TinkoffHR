package com.example.tinkoff_hr.ui.faq.MeetUp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityMeetUpBinding


class MeetUpActivity : AppCompatActivity() {

    private val binging: ActivityMeetUpBinding by lazy {
        ActivityMeetUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.title = "Meetup's"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binging.apply {

            buttonWhatDoSpeaker.setOnClickListener {
                expandableWhatDoSpeaker.toggle()
                if (expandableWhatDoSpeaker.isExpanded) {
                    textWhatDoSpeaker.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_up_24)
                } else {
                    textWhatDoSpeaker.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_down_24)
                }
            }

            buttonListenerInformation.setOnClickListener {
                expandableListenerInformation.toggle()
                if (expandableListenerInformation.isExpanded) {
                    textListenerInformation.setEndIconDrawable(R.drawable.ic_baseline_arrow_drop_up_24)
                } else {
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