package com.maehara08.mobiledeveloperchallenge.reposiotry

import android.app.Application

interface Repository {
  fun init(application: Application)
}