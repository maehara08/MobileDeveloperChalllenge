package com.maehara08.mobiledeveloperchallenge.ui.main.item

import com.maehara08.mobiledeveloperchallenge.R
import com.maehara08.mobiledeveloperchallenge.databinding.ItemCurrencyRateBinding
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate
import com.xwray.groupie.databinding.BindableItem

class CurrencyRateItem(
  val model: CurrencyRate
) : BindableItem<ItemCurrencyRateBinding>() {
  override fun getLayout(): Int = R.layout.item_currency_rate

  override fun bind(
    viewBinding: ItemCurrencyRateBinding,
    position: Int
  ) {
    viewBinding.model = model
  }
}