package com.maehara08.mobiledeveloperchallenge.reposiotry.remote.service

import com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model.CurrenciesList
import com.maehara08.mobiledeveloperchallenge.reposiotry.remote.model.CurrenciesRate
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {
  @GET("/list")
  fun getCurrencyList(
    @Query("access_key") accessKey: String
  ): Deferred<CurrenciesList>

  @GET("/live")
  fun getCurrencyRate(
    @Query("access_key") accessKey: String,
    @Query("source") source: String
  ): Deferred<CurrenciesRate>
}