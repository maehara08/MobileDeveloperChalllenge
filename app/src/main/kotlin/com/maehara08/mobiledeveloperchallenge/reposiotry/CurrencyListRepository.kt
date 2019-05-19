package com.maehara08.mobiledeveloperchallenge.reposiotry

import android.app.Application
import com.maehara08.mobiledeveloperchallenge.BuildConfig
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.DataBase
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.model.Currency
import com.maehara08.mobiledeveloperchallenge.reposiotry.remote.service.CurrencyListService
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred

object CurrencyListRepository : Repository {
  private lateinit var application: Application
  private val currencyListService =
    RepositoryConstants.retrofit.create(CurrencyListService::class.java)

  private lateinit var database: DataBase
  override fun init(
    application: Application,
    database: DataBase
  ) {
    this.application = application
    this.database = database
  }

  suspend fun getList(): Deferred<List<Currency>> {
    val deferred = CompletableDeferred<List<Currency>>()
    Network.request(
        application,
        currencyListService.getCurrencyList(BuildConfig.ACCESS_TOKEN),
        {
          val arrayList = arrayListOf<Currency>()
          for (key in it.currencies.keySet()) {
            val value = it.currencies[key].asString
            arrayList.add(Currency(key, value))
          }
          deferred.complete(arrayList)
        },
        {
          deferred.completeExceptionally(it)
        })
    return deferred
  }
}