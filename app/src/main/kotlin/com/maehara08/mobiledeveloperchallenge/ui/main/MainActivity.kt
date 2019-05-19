package com.maehara08.mobiledeveloperchallenge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.maehara08.mobiledeveloperchallenge.R
import com.maehara08.mobiledeveloperchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    val viewModel = ViewModelProviders.of(this)
        .get(MainViewModel::class.java)
    viewModel.getCurrencyList()
  }
}
