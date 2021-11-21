package com.example.tinkoff_hr.ui.faq.education

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityEducationBinding

class EducationActivity : AppCompatActivity() {

    private val binging: ActivityEducationBinding by lazy {
        ActivityEducationBinding.inflate(layoutInflater)
    }
    private val cardEducationAdapter = CardEducationAdapter()
    private val fotoArray by lazy {
        arrayOf(
            R.drawable.scala,
            R.drawable.ios,
            R.drawable.frontend,
            R.drawable.devops
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.title = "Образование"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        init()
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

    private fun init() {
        binging.recEducation.apply {
            layoutManager = LinearLayoutManager(this@EducationActivity)
            adapter = cardEducationAdapter
        }

        cardEducationAdapter.addList(
            listOf(
                CardEducation(
                    fotoArray[0], "Scala",
                    "информация об образовательной программе информация об" +
                            " образовательной программе информация об образовательной программе"
                ),
                CardEducation(
                    fotoArray[1], "IOS",
                    "информация об образовательной программе информация об" +
                            " образовательной программе информация об образовательной программе"
                ),
                CardEducation(
                    fotoArray[2], "Frontend",
                    "информация об образовательной программе информация об" +
                            " образовательной программе информация об образовательной программе"
                ),
                CardEducation(
                    fotoArray[3], "DevOps",
                    "информация об образовательной программе информация об" +
                            " образовательной программе информация об образовательной программе"
                )
            )
        )
    }
}