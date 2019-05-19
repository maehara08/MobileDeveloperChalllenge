package com.maehara08.mobiledeveloperchallenge.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.maehara08.mobiledeveloperchallenge.reposiotry.CurrencyListRepository
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.Currency
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application) {
  val currencyData = MutableLiveData<List<Currency>>()
  val currencyRateData = MutableLiveData<List<CurrencyRate>>()

  init {
    getCurrencyList()
  }

  fun getCurrencyList() {
    viewModelScope.launch {
      try {
        val list = CurrencyListRepository.getCurrencyList()
            .await()
        currencyData.postValue(list)
      } catch (e: Exception) {
        Timber.e(e)
      }
    }
  }

  fun getCurrencyRate(source: String) {
    viewModelScope.launch {
      try {
        val list = CurrencyListRepository.getCurrencyRateList(source)
            .await()
        currencyRateData.postValue(list)
      } catch (e: Exception) {
        Timber.e(e)
      }
    }
  }
}