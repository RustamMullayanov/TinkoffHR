package com.example.tinkoff_hr.ui.orders.basket

import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.databinding.ActivityBasketBinding
import com.example.tinkoff_hr.presentation.WorkerProfilePresenter
import com.example.tinkoff_hr.presentation.orders.basket.BasketPresenter
import com.example.tinkoff_hr.ui.orders.ProductItem
import com.example.tinkoff_hr.ui.workers.WorkerAdapter
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity
import com.example.tinkoff_hr.views.orders.BasketView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class BasketActivity : MvpAppCompatActivity(), BasketView {

    @Inject
    lateinit var presenterProvider: Provider<BasketPresenter>

    private val basketPresenter by moxyPresenter { presenterProvider.get() }

    private val binding: ActivityBasketBinding by lazy {
        ActivityBasketBinding.inflate(layoutInflater)
    }

    private lateinit var basketAdapter: BasketAdapter

    var products: List<ProductItem> = listOf(
        ProductItem("", "Milk", listOf()),
        ProductItem("", "Milk", listOf()),
        ProductItem("", "Milk", listOf())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        basketAdapter = BasketAdapter(clickListener)

        with(binding) {
            recProducts.apply {
                layoutManager = LinearLayoutManager(this.context)
                adapter = basketAdapter
                basketAdapter.setNewItems(products)
            }
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

    override fun showProductsInfo(products: List<ProductItem>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

    private val clickListener = object : BasketAdapter.ClickListener {

        override fun onProductClicked() {
            TODO("Not yet implemented")
        }

    }
}