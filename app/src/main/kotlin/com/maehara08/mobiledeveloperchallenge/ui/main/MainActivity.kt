package com.maehara08.mobiledeveloperchallenge.ui.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.maehara08.mobiledeveloperchallenge.R
import com.maehara08.mobiledeveloperchallenge.databinding.ActivityMainBinding
import com.maehara08.mobiledeveloperchallenge.ui.main.adapter.CurrencyRateAdapter

class MainActivity : AppCompatActivity() {
  companion object {
    private const val SPAN_COUNT = 2
  }

  private lateinit var binding: ActivityMainBinding
  private val arrayAdapter: ArrayAdapter<String> by lazy {
    ArrayAdapter<String>(
        this,
        android.R.layout.simple_spinner_item
    ).apply {
      setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    val viewModel = ViewModelProviders.of(this)
        .get(MainViewModel::class.java)
    with(binding.spinner) {
      adapter = arrayAdapter
      onItemSelectedListener = object : OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}

        override fun onItemSelected(
          parent: AdapterView<*>?,
          view: View?,
          position: Int,
          id: Long
        ) {
          arrayAdapter.getItem(position)
              ?.let {
                viewModel.getCurrencyRate(it)
              }
        }
      }
    }

    with(binding.recyclerView) {
      layoutManager = GridLayoutManager(this@MainActivity, SPAN_COUNT)
      adapter = CurrencyRateAdapter(viewModel.currencyRateData, this@MainActivity)
    }

    viewModel.currencyData.observe(this, Observer { currencyList ->
      currencyList.map { it.name }
          .let(arrayAdapter::addAll)
    })
  }
}
