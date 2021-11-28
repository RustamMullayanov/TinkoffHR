package com.example.tinkoff_hr.ui.workers.worker_profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.tinkoff_hr.databinding.ActivityWorkerProfileBinding

class WorkerProfileActivity : AppCompatActivity() {

    private val binding: ActivityWorkerProfileBinding by lazy {
        ActivityWorkerProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Профиль(ФИО)"
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