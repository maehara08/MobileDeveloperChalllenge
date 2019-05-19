package com.maehara08.mobiledeveloperchallenge.ui

import android.app.Application
import androidx.room.Room
import com.maehara08.mobiledeveloperchallenge.BuildConfig
import com.maehara08.mobiledeveloperchallenge.reposiotry.CurrencyListRepository
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.DataBase
import timber.log.Timber

class CurrencyApplication : Application() {
  companion object {
    private const val DB_NAME = "my_db.db"
  }

  lateinit var dataBase: DataBase

  override fun onCreate() {
    super.onCreate()

    //db
    dataBase = Room.databaseBuilder(this, DataBase::class.java, DB_NAME)
        .build()

    // Repository
    listOf(
        CurrencyListRepository
    ).forEach { it.init(this) }

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}