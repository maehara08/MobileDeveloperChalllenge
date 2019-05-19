package com.maehara08.mobiledeveloperchallenge.reposiotry.local

import android.content.SharedPreferences

interface Preference {
  fun init(sharedPreferences: SharedPreferences)
}