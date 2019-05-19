package com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency(
  @PrimaryKey
  val name: String,
  val description: String
)