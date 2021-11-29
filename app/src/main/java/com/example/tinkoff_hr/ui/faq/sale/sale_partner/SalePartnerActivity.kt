package com.example.tinkoff_hr.ui.faq.sale.sale_partner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.tinkoff_hr.databinding.ActivityBusinessTripBinding
import com.example.tinkoff_hr.databinding.ActivitySalePartnerBinding

class SalePartnerActivity : AppCompatActivity() {

    private val binging: ActivitySalePartnerBinding by lazy { ActivitySalePartnerBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Партнер"
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