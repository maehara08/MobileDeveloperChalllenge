package com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model

import com.google.gson.JsonObject

data class ApiResponse(
  val success: Boolean,
  val terms: String,
  val privacy: String,
  val error: ApiError?,
  val currencies: JsonObject
)