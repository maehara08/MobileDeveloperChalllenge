package com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity

import androidx.room.Entity
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate

@Entity(primaryKeys = ["name", "source"])
data class CurrencyRate(
  val name: String,
  val rate: Float,
  val source: String
)

fun CurrencyRate.toEntityCurrencyRate() =
  com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.CurrencyRate(name, rate, source)