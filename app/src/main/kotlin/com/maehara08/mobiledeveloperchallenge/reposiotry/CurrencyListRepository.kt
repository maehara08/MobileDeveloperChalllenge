package com.maehara08.mobiledeveloperchallenge.reposiotry

import android.app.Application
import com.maehara08.mobiledeveloperchallenge.BuildConfig
import com.maehara08.mobiledeveloperchallenge.entension.isWithin30Minutes
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.DataBase
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.UpdatedAtPreference
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.toEntityCurrency
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.toEntityCurrencyRate
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.Currency
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.CurrencyRate
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.toLocalCurrency
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.toLocalCurrencyRate
import com.maehara08.mobiledeveloperchallenge.reposiotry.remote.service.CurrencyService
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

object CurrencyListRepository : Repository {
  private lateinit var application: Application
  private val currencyListService =
    RepositoryConstants.retrofit.create(CurrencyService::class.java)

  private lateinit var database: DataBase
  override fun init(
    application: Application,
    database: DataBase
  ) {
    this.application = application
    this.database = database
  }

  suspend fun getCurrencyList(): Deferred<List<Currency>> {
    val deferred = CompletableDeferred<List<Currency>>()
    CoroutineScope(Dispatchers.IO).launch {
      val isWithin30Minutes = UpdatedAtPreference.currencyList.isWithin30Minutes()
      if (!isWithin30Minutes) {
        Network.request(
            application,
            currencyListService.getCurrencyList(BuildConfig.ACCESS_TOKEN),
            {
              val currencyList = arrayListOf<Currency>()
              for (key in it.currencies.keySet()) {
                val value = it.currencies[key].asString
                currencyList.add(Currency(key, value))
              }
              deferred.complete(currencyList)
              currencyList.map { currency ->
                currency.toEntityCurrency()
              }
                  .let(database.currencyDao()::insertCurrencies)
              UpdatedAtPreference.currencyList = Date()
            },
            {
              deferred.completeExceptionally(it)
            })
      } else {
        database.currencyDao()
            .findAll()
            .map {
              it.toLocalCurrency()
            }
            .let(deferred::complete)
      }
    }
        .join()
    return deferred
  }

  suspend fun getCurrencyRateList(source: String): Deferred<List<CurrencyRate>> {
    val deferred = CompletableDeferred<List<CurrencyRate>>()
    CoroutineScope(Dispatchers.IO).launch {
      val isWithin30Minutes =
        UpdatedAtPreference
            .currencyRate(source)
            .isWithin30Minutes()
      if (!isWithin30Minutes) {
        Network.request(
            application,
            currencyListService.getCurrencyRate(BuildConfig.ACCESS_TOKEN, source),
            {
              val currencyRateList = arrayListOf<CurrencyRate>()
              for (key in it.quotes.keySet()) {
                val value = it.quotes[key].asFloat
                currencyRateList.add(CurrencyRate(key, value, source))
              }
              deferred.complete(currencyRateList)
              currencyRateList.map { currencyRate ->
                currencyRate.toEntityCurrencyRate()
              }
                  .let(database.currencyRateDao()::insertCurrencyRates)
              UpdatedAtPreference.currencyList = Date()
            },
            {
              deferred.completeExceptionally(it)
            })
      } else {
        database.currencyRateDao()
            .findAll(source)
            .map {
              it.toLocalCurrencyRate()
            }
            .let(deferred::complete)
      }
    }
        .join()
    return deferred
  }
}
