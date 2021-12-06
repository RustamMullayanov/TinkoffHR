package com.example.tinkoff_hr.ui.where_eat.eatery_information

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tinkoff_hr.databinding.ActivityEateryInformationBinding
import com.example.tinkoff_hr.databinding.ActivityWorkerProfileBinding

class EateryInformationActivity : AppCompatActivity() {

    private val binding: ActivityEateryInformationBinding by lazy {
        ActivityEateryInformationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}