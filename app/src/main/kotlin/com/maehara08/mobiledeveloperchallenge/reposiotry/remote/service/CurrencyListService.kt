package com.maehara08.mobiledeveloperchallenge.reposiotry.remote.service

import com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model.CurrenciesList
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyListService {
  @GET("/list")
  fun getCurrencyList(
    @Query("access_key") accessKey: String
  ): Deferred<CurrenciesList>
}