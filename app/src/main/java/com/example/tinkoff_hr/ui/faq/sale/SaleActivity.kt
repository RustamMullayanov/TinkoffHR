package com.example.tinkoff_hr.ui.faq.sale

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivitySaleBinding
import com.example.tinkoff_hr.ui.faq.sale.sale_partner.SalePartnerActivity
import com.example.tinkoff_hr.ui.tribute.item.TitleItem

class SaleActivity : AppCompatActivity() {

    private val binging: ActivitySaleBinding by lazy { ActivitySaleBinding.inflate(layoutInflater) }
    private val photoArray by lazy {
        arrayOf(
            R.drawable.rostelecom,
            R.drawable.mmk,
            R.drawable.coca,
            R.drawable.beeline
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)
        supportActionBar?.title = this.getString(R.string.sale_partners)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu_sale, menu)
        return true
    }

    private val clickListener = object : SaleAdapter.ClickListener {

        override fun onSaleItemClicked() {
            val intent = Intent(this@SaleActivity, SalePartnerActivity::class.java)
            startActivity(intent)
        }

        override fun onTitleItemClicked(id: String) {
            Toast.makeText(
                this@SaleActivity,
                "You clicked on item with id: $id",
                Toast.LENGTH_SHORT
            ).show()
        }

    }


    private fun init() {
        val saleAdapter = SaleAdapter(clickListener)

        binging.recView.apply {
            layoutManager = LinearLayoutManager(this@SaleActivity)
            adapter = saleAdapter
        }

        saleAdapter.setNewItems(
            listOf(
                TitleItem(getString(R.string.partners_tinkoff)),
                SaleItem(photoArray[0], "Самая лучшая компания по мнению никого", "Ростелеком"),
                SaleItem(photoArray[1], "Благодаря нам верстальщик этой страницы умрёт в 30", "ММК"),
                SaleItem(photoArray[2], "Много сахара не бывает", "Coca-Cola"),
                SaleItem(photoArray[0], "Самая лучшая компания по мнению никого", "Ростелеком"),
                SaleItem(photoArray[1], "Благодаря нам верстальщик этой страницы умрёт в 30", "ММК"),
                SaleItem(photoArray[2], "Много сахара не бывает", "Coca-Cola"),
                SaleItem(photoArray[0], "Самая лучшая компания по мнению никого", "Ростелеком"),
                SaleItem(photoArray[1], "Благодаря нам верстальщик этой страницы умрёт в 30", "ММК"),
                SaleItem(photoArray[2], "Много сахара не бывает", "Coca-Cola"),
                SaleItem(photoArray[3], "Любимый певец Дима", "Билайн")
            )
        )
    }
}