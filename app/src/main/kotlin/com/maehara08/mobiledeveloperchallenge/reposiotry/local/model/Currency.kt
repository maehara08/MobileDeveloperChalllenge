package com.maehara08.mobiledeveloperchallenge.reposiotry.local.model

import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.Currency

data class Currency(
  val name: String,
  val description: String
)

fun Currency.toLocalCurrency() =
  com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.Currency(name, description)