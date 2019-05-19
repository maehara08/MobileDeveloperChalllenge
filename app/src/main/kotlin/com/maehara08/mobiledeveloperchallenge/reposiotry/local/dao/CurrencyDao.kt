package com.maehara08.mobiledeveloperchallenge.reposiotry.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.Currency

@Dao
interface CurrencyDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun createCurrency(currencies: List<Currency>)

  @Query("SELECT * FROM currency")
  fun findAll(): LiveData<List<Currency>>

  @Delete
  fun delete(currency: Currency)
}