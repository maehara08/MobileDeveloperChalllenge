package com.maehara08.mobiledeveloperchallenge.ui.main.adapter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate
import com.maehara08.mobiledeveloperchallenge.ui.main.item.CurrencyRateItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class CurrencyRateAdapter(
  currencyRatesData: LiveData<List<CurrencyRate>>,
  lifecycleOwner: LifecycleOwner
) : GroupAdapter<ViewHolder>() {
  init {
    currencyRatesData.observe(lifecycleOwner, Observer {
      it.map(::CurrencyRateItem)
          .let(::update)
    })
  }
}