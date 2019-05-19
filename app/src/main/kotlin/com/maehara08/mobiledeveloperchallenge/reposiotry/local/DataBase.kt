package com.maehara08.mobiledeveloperchallenge.reposiotry.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.dao.CurrencyDao
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.Currency

@Database(entities = [Currency::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
  abstract fun currencyDao(): CurrencyDao
}