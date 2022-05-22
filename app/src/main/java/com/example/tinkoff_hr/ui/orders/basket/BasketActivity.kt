package com.example.tinkoff_hr.ui.orders.basket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tinkoff_hr.databinding.ActivityBasketBinding
import com.example.tinkoff_hr.databinding.ActivityWorkerProfileBinding

class BasketActivity : AppCompatActivity() {

    private val binding: ActivityBasketBinding by lazy {
        ActivityBasketBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}