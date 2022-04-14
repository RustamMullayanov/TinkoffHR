package com.example.tinkoff_hr.ui.where_eat.eatery_information

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.databinding.ActivityEateryInformationBinding
import com.example.tinkoff_hr.databinding.DialogEateryBinding
import com.example.tinkoff_hr.domain.entities.restaurant.Restaurant
import com.example.tinkoff_hr.domain.entities.restaurant.RestaurantReview
import com.example.tinkoff_hr.presentation.restaurant.EateryInfoPresenter
import com.example.tinkoff_hr.views.restaurant.EateryInfoView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class EateryInformationActivity : MvpAppCompatActivity(), EateryInfoView {

    @Inject
    lateinit var presenterProvider: Provider<EateryInfoPresenter>

    private val eateryInfoPresenter by moxyPresenter { presenterProvider.get() }

    private val binding: ActivityEateryInformationBinding by lazy {
        ActivityEateryInformationBinding.inflate(layoutInflater)
    }

    private val reviewAdapter = ReviewEateryAdapter()

    private val id: String by lazy { intent.getStringExtra(EXTRA_ID)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.recReview.apply {
            layoutManager = LinearLayoutManager(this@EateryInformationActivity)
            adapter = reviewAdapter
        }

        binding.buttonAdd.setOnClickListener {
            createDialog()
        }

        eateryInfoPresenter.onAppearing(id)
    }

    private fun createDialog() {

        val dialogBinding = DialogEateryBinding.inflate(
            layoutInflater, binding.root, false
        )

        dialogBinding.apply {

            val dialog = AlertDialog.Builder(this@EateryInformationActivity)
                .setView(dialogLayout)
                .create()

            buttonCancel.setOnClickListener {
                dialog.dismiss()
            }

            buttonAdd.setOnClickListener {
                eateryInfoPresenter.saveRestaurantReview(
                    "1",
                    RestaurantReview(
                        "",
                        "1",
                        "Иванов Петя",
                        5.0,
                        id,
                        dialogBinding.fieldReview.text.toString()
                    )
                )
                dialog.dismiss()
            }
            dialog.show()
        }
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

    override fun setRestaurantInfo(restaurant: Restaurant) {
        supportActionBar?.title = restaurant.name
        var businessLunch = "Нет"
        if (restaurant.isHasLunch)
            businessLunch = "Есть"
        with(binding) {
            fieldBusinessLunch.setText(businessLunch)
            fieldAverageCost.setText(restaurant.averageCost.toString())
        }
    }

    override fun setRestaurantReviewsInfo(reviews: List<RestaurantReview>) {
        if (reviews.isNotEmpty()) {
            reviewAdapter.setList(reviews)
            binding.emptyReviewField.visibility = View.GONE
        }

    }

    override fun setRestaurantReviewInfo(review: RestaurantReview) {
        reviewAdapter.setReview(review)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val EXTRA_ID = "extra_id"

        fun createIntent(context: Context, id: String): Intent {
            return Intent(context, EateryInformationActivity::class.java).apply {
                putExtra(EXTRA_ID, id)
            }
        }
    }
}