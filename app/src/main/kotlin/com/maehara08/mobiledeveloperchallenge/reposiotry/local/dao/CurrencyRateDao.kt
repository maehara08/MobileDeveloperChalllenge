package com.maehara08.mobiledeveloperchallenge.reposiotry.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.entity.CurrencyRate

@Dao
interface CurrencyRateDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCurrencyRates(currencies: List<CurrencyRate>)

  @Query("SELECT * FROM CurrencyRate")
  fun findAll(): List<CurrencyRate>

  @Query("SELECT * FROM CurrencyRate WHERE source = :source")
  fun findAll(source: String): List<CurrencyRate>

  @Delete
  fun delete(currency: CurrencyRate)
}