package com.example.tinkoff_hr.ui.faq.education

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityEducationBinding
import com.example.tinkoff_hr.utils.PaddingItemDecoration
import com.example.tinkoff_hr.utils.dpToPx

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
            addItemDecoration(
                PaddingItemDecoration(
                    bottom = dpToPx(DECORATOR_PADDING),
                    filter = { holder ->
                        holder.adapterPosition == cardEducationAdapter.itemCount - 1
                    })
            )
            addItemDecoration(
                PaddingItemDecoration(
                    top = dpToPx(DECORATOR_PADDING),
                    filter = { holder ->
                        holder.adapterPosition == 0
                    })
            )
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

    private companion object {
        const val DECORATOR_PADDING = 12F
    }
}