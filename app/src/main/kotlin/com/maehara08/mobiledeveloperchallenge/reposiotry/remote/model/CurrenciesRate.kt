package com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model

import com.google.gson.JsonObject

data class CurrenciesRate(
  val success: Boolean,
  val terms: String,
  val privacy: String,
  val error: ApiError?,
  val source: String,
  val quotes: JsonObject
)