package com.example.tinkoff_hr.ui.orders

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.actionbar.SettingsActivity
import com.example.tinkoff_hr.databinding.FragmentOrdersBinding
import com.example.tinkoff_hr.presentation.orders.OrdersPresenter
import com.example.tinkoff_hr.ui.orders.basket.BasketActivity
import com.example.tinkoff_hr.views.orders.OrdersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class OrdersFragment : MvpAppCompatFragment(R.layout.fragment_orders), OrdersView {

    private lateinit var binding: FragmentOrdersBinding
    private lateinit var basketMenu: MenuItem
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productFilterAdapter: ProductFilterAdapter

    @Inject
    lateinit var presenterProvider: Provider<OrdersPresenter>

    private val ordersPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrdersBinding.bind(view)
        setHasOptionsMenu(true)

        productAdapter = ProductAdapter(clickListenerProduct)
        productFilterAdapter = ProductFilterAdapter(clickListenerFilter)

        with(binding) {

            recFilter.apply {
                layoutManager =
                    LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = productFilterAdapter
                ordersPresenter.getProductFilters()
            }

            recProducts.apply {
                layoutManager = GridLayoutManager(this.context, 2)
                adapter = productAdapter
                ordersPresenter.getProducts()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.action_menu_basket, menu)
        basketMenu = menu.findItem(R.id.menu_basket)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.menu_settings -> {
                startActivity(Intent(context, SettingsActivity::class.java))
                return true
            }
            R.id.menu_basket -> {
                basketMenu.setIcon(R.drawable.ic_shopping_cart2)
                startActivity(Intent(context, BasketActivity::class.java))

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private val clickListenerProduct = object : ProductAdapter.ClickListener {

        override fun onProductClicked(productId: String) {
            basketMenu.setIcon(R.drawable.ic_shopping_cart_point2)
        }
    }

    private val clickListenerFilter = object : ProductFilterAdapter.ClickListener {

        override fun onProductFilterClicked(productType: String, isSelected: Boolean) {
            if (isSelected) ordersPresenter.addFilter(productType)
            else ordersPresenter.removeFilter(productType)
            ordersPresenter.getProductsByFilter()
        }
    }

    override fun showProductsInfo(products: List<ProductItem>) {
        productAdapter.setNewItems(products)
    }

    override fun showProductFiltersInfo(productFilters: List<ProductFilterItem>) {
        productFilterAdapter.setNewItems(productFilters)
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }

}