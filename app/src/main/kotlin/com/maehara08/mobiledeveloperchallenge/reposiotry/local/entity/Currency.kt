package com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.Currency

@Entity
data class Currency(
  @PrimaryKey
  val name: String,
  val description: String
)

fun Currency.toEntityCurrency() =
  com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.Currency(name, description)