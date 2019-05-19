package com.maehara08.mobiledeveloperchallenge.reposiotry.local.model

data class CurrencyRate(
  val name: String,
  val rate: Float
)

fun CurrencyRate.toLocalCurrency() =
  com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate(name, rate)