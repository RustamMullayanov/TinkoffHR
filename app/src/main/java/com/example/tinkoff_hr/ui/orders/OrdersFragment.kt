package com.example.tinkoff_hr.ui.orders

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentOrdersBinding
import com.example.tinkoff_hr.presentation.orders.OrdersPresenter
import com.example.tinkoff_hr.views.orders.OrdersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class OrdersFragment : MvpAppCompatFragment(R.layout.fragment_orders), OrdersView {

    private lateinit var binding: FragmentOrdersBinding
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

    private val clickListenerProduct = object : ProductAdapter.ClickListener {

        override fun onProductClicked(productId: String) {

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