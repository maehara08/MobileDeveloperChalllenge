package com.maehara08.mobiledeveloperchallenge.reposiotry

import android.app.Application
import androidx.room.Database

interface Repository {
  fun init(
    application: Application,
    database: Database
  )
}