package com.maehara08.mobiledeveloperchallenge.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.maehara08.mobiledeveloperchallenge.reposiotry.CurrencyListRepository
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.Currency
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application) {
  val currencyData = MutableLiveData<List<Currency>>()

  fun getCurrencyList() {
    viewModelScope.launch {
      try {
        val list = CurrencyListRepository.getList()
            .await()
        currencyData.postValue(list)
      } catch (e: Exception) {
        Timber.e(e)
      }
    }
  }
}