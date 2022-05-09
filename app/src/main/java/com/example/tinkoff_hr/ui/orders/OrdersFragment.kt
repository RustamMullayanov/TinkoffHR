package com.example.tinkoff_hr.ui.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentOrdersBinding
import com.example.tinkoff_hr.databinding.FragmentWorkersBinding
import com.example.tinkoff_hr.ui.workers.WorkerAdapter
import com.example.tinkoff_hr.ui.workers.worker_profile.WorkerProfileActivity

class OrdersFragment : Fragment(R.layout.fragment_orders) {

    private lateinit var binding: FragmentOrdersBinding
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productFilterAdapter: ProductFilterAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrdersBinding.bind(view)

        productAdapter = ProductAdapter(clickListenerProduct)
        productFilterAdapter = ProductFilterAdapter(clickListenerFilter)

        val filter = listOf(
            ProductFilterItem("1","Молочка"),
            ProductFilterItem("2","Напиток"),
            ProductFilterItem("1","Молочка"),
            ProductFilterItem("2","Напиток"),
            ProductFilterItem("1","Молочка"),
            ProductFilterItem("2","Напиток"),
            ProductFilterItem("1","Молочка"),
            ProductFilterItem("2","Напиток"),
        )

        val product = listOf(
            ProductItem("1", "Колаghdbofgfpdindpinpoeinpboenpbe fnfofvifnvdpnfpknpkvfdnpvfdnpvfdnpvfd kvfdnkpvfdnvfdnpefpkefpvnonvefpnpefvvef klvfnpkvfnpvfdnpfdpkfdkvmdk ",
                listOf("Напиток")),
            ProductItem("1", "Пепси", listOf("Напиток")),
            ProductItem("1", "Творог", listOf("Молочка")),
            ProductItem("1", "Кола", listOf("Напиток")),
            ProductItem("1", "Пепси", listOf("Напиток")),
            ProductItem("1", "Творог", listOf("Молочка")),
        )

        with(binding){

            recFilter.apply {
                layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL,false)
                adapter = productFilterAdapter
                productFilterAdapter.setNewItems(filter)
            }

            recProducts.apply {
                layoutManager = GridLayoutManager(this.context,2)
                adapter = productAdapter
                productAdapter.setNewItems(product)
            }
        }
    }

    private val clickListenerProduct = object : ProductAdapter.ClickListener {

        override fun onProductClicked(productId: String) {

        }
    }

    private val clickListenerFilter = object : ProductFilterAdapter.ClickListener {

        override fun onProductFilterClicked(productType: String) {

        }
    }

}