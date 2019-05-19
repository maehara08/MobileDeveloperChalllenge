package com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model

import java.io.Serializable

data class ApiError(
  val code: Int,
  val info: String
) : Serializable