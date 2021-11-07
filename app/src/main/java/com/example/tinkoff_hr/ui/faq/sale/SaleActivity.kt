package com.example.tinkoff_hr.ui.faq.sale

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivitySaleBinding

class SaleActivity : AppCompatActivity() {

    private val binging: ActivitySaleBinding by lazy { ActivitySaleBinding.inflate(layoutInflater) }
    private val stateAdapter = StateAdapter()
    private val fotoArray by lazy {
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Партнёры"
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
           // R.id.menu_profile -> this.finish()
           // R.id.menu_callback -> this.finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        binging.recView.apply {
            layoutManager = LinearLayoutManager(this@SaleActivity)
            adapter = stateAdapter

        }

        stateAdapter.addList(
            listOf(
                State(fotoArray[0], "Самая лучшая компания по мнению никого", "Ростелеком"),
                State(fotoArray[1], "Благодаря нам верстальщик этой страницы умрёт в 30", "ММК"),
                State(fotoArray[2], "Много сахара не бывает", "Coca-Cola"),
                State(fotoArray[3], "Любимый певец Дима", "Билайн")
            )
        )
    }
}