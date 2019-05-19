package com.maehara08.mobiledeveloperchallenge.ui

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.maehara08.mobiledeveloperchallenge.BuildConfig
import com.maehara08.mobiledeveloperchallenge.reposiotry.CurrencyListRepository
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.DataBase
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.UpdatedAtPreference
import timber.log.Timber

class CurrencyApplication : Application() {
  companion object {
    private const val DB_NAME = "my_db.db"
    private const val PREF_NAME = "my_pref"
  }

  lateinit var dataBase: DataBase

  override fun onCreate() {
    super.onCreate()

    //db
    dataBase = Room.databaseBuilder(this, DataBase::class.java, DB_NAME)
        .build()

    val preference = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    // local
    listOf(UpdatedAtPreference).forEach {
      it.init(preference)
    }

    // Repository
    listOf(
        CurrencyListRepository
    ).forEach { it.init(this, dataBase) }

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}