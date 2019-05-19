package com.maehara08.mobiledeveloperchallenge.reposiotry.local.model

import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.CurrencyRate

data class CurrencyRate(
  val name: String,
  val rate: Float,
  val source: String
)

fun CurrencyRate.toLocalCurrencyRate() =
  com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate(name, rate, source)