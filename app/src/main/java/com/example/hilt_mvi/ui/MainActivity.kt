package com.example.hilt_mvi.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hilt_mvi.adapter.HorizontalProductAdapter
import com.example.hilt_mvi.R
import com.example.hilt_mvi.databinding.ActivityMainBinding
import com.example.hilt_mvi.model.Product
import com.example.hilt_mvi.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetProductEvent)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this) { dataState ->
            when (dataState) {
                is DataState.Success<List<Product>> -> {
                    displayProgressBar(false)
                    setUpRecyclerView(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        }
    }

    private fun displayError(message: String?) {
        if (message != null) binding.errorText.text = message else binding.errorText.text =
            "Unknown error."
    }

    private fun setUpRecyclerView(products: List<Product>) {
        //Setup Hor recyclerView
        val adapterHor = HorizontalProductAdapter()
        adapterHor.submitList(products)
        binding.mainRecyclerHor.adapter = adapterHor
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.spinKit.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

}