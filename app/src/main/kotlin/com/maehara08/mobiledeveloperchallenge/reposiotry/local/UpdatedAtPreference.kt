package com.maehara08.mobiledeveloperchallenge.reposiotry.local

import android.content.SharedPreferences
import androidx.core.content.edit
import java.util.Date

object UpdatedAtPreference : Preference {
  private const val DEFAULT_INT = -1L
  private lateinit var sharedPreferences: SharedPreferences

  override fun init(sharedPreferences: SharedPreferences) {
    this.sharedPreferences = sharedPreferences
  }

  var currencyList: Date?
    get() {
      val time = sharedPreferences.getLong(Key.CURRENCY_LIST, DEFAULT_INT)
      if (time == DEFAULT_INT) return null
      return Date(time)
    }
    set(value) {
      sharedPreferences.edit {
        putLong(Key.CURRENCY_LIST, value?.time ?: DEFAULT_INT)
      }
    }

  var currencyRate: Date?
    get() {
      val time = sharedPreferences.getLong(Key.CURRENCY_RATE, DEFAULT_INT)
      if (time == DEFAULT_INT) return null
      return Date(time)
    }
    set(value) {
      sharedPreferences.edit {
        putLong(Key.CURRENCY_RATE, value?.time ?: DEFAULT_INT)
      }
    }

  private object Key {
    const val CURRENCY_LIST = "currency_list"
    const val CURRENCY_RATE = "currency_rate"
  }
}