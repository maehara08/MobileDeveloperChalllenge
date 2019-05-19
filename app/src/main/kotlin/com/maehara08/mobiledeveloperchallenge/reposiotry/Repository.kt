package com.maehara08.mobiledeveloperchallenge.reposiotry

import android.app.Application
import com.maehara08.mobiledeveloperchallenge.reposiotry.local.DataBase

interface Repository {
  fun init(
    application: Application,
    database: DataBase
  )
}