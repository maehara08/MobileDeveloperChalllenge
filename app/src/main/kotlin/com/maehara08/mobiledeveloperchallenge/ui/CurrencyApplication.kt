package com.maehara08.mobiledeveloperchallenge.ui

import android.app.Application
import com.maehara08.mobiledeveloperchallenge.BuildConfig
import com.maehara08.mobiledeveloperchallenge.reposiotry.CurrencyListRepository
import timber.log.Timber

class CurrencyApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    // Repository
    listOf(
        CurrencyListRepository
    ).forEach { it.init(this) }

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}