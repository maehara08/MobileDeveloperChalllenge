package com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model

import com.google.gson.JsonObject

data class CurrenciesList(
  val success: Boolean,
  val terms: String,
  val privacy: String,
  val error: ApiError?,
  val currencies: JsonObject
)