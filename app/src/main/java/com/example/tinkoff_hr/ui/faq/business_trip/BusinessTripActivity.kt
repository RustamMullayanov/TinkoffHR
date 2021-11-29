package com.example.tinkoff_hr.ui.faq.business_trip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.tinkoff_hr.databinding.ActivityBusinessTripBinding

class BusinessTripActivity : AppCompatActivity() {

    private val binging: ActivityBusinessTripBinding by lazy { ActivityBusinessTripBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.title = "Командировки"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binging.apply {

            buttonAddress.setOnClickListener{
                expandableAddress.toggle()
            }

            buttonContacts.setOnClickListener{
                expandableContacts.toggle()
            }

            buttonPass.setOnClickListener{
                expandablePass.toggle()
            }

            buttonStepsArrival.setOnClickListener{
                expandableStepsArrival.toggle()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }

        return super.onOptionsItemSelected(item)
    }
}