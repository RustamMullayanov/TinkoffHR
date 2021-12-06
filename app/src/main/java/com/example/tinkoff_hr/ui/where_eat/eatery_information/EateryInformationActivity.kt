package com.example.tinkoff_hr.ui.where_eat.eatery_information

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.databinding.ActivityEateryInformationBinding
import com.example.tinkoff_hr.databinding.ActivityWorkerProfileBinding
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity

class EateryInformationActivity : AppCompatActivity() {

    private val binging: ActivityEateryInformationBinding by lazy {
        ActivityEateryInformationBinding.inflate(layoutInflater)
    }

    private val reviewAdapter = ReviewEateryAdapter()

    private val id: String by lazy { intent.getStringExtra(EXTRA_ID)!! }

    companion object {

        private const val EXTRA_ID = "extra_id"

        fun createIntent(context: Context, id: String): Intent {
            return Intent(context, EateryInformationActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Название заведения"

        binging.recReview.apply {
            layoutManager = LinearLayoutManager(this@EateryInformationActivity)
            adapter = reviewAdapter
        }

        reviewAdapter.setList(
            listOf(
                ReviewEatery(
                    "Иван Иванов", 1,
                    "Всё очень вкусно, всегда сюда хожу и ходил бы ещё пол жизнию Но есть одно но!!! Супчики обычно с волосами и ногтями. Но для такого заведения это норма"
                ),
                ReviewEatery(
                    "Борис Сидорович", 1,
                    "Одним словом - помои"
                ),
                ReviewEatery(
                    "Иван Иванов", 1,
                    "Всё очень вкусно, всегда сюда хожу и ходил бы ещё пол жизнию Но есть одно но!!! Супчики обычно с волосами и ногтями. Но для такого заведения это норма"
                ),
                ReviewEatery(
                    "Борис Сидорович", 1,
                    "Одним словом - помои"
                ),
                ReviewEatery(
                    "Иван Иванов", 1,
                    "Всё очень вкусно, всегда сюда хожу и ходил бы ещё пол жизнию Но есть одно но!!! Супчики обычно с волосами и ногтями. Но для такого заведения это норма"
                ),
                ReviewEatery(
                    "Борис Сидорович", 1,
                    "Одним словом - помои"
                ),
            )
        )
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