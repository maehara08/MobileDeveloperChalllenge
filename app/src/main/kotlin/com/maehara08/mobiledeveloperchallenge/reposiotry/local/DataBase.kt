package com.maehara08.mobiledeveloperchallenge.reposiotry.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.dao.CurrencyDao
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.dao.CurrencyRateDao
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.Currency
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.CurrencyRate

@Database(entities = [Currency::class, CurrencyRate::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
  abstract fun currencyDao(): CurrencyDao

  abstract fun currencyRateDao(): CurrencyRateDao
}