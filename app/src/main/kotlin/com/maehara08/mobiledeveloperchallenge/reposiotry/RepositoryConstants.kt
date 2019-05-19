package com.maehara08.mobiledeveloperchallenge.reposiotry

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.maehara08.mobiledeveloperchallenge.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RepositoryConstants {
  private const val BASE_URL = "https://apilayer.net/api/"
  private val logLevel =
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
  private val okClient = OkHttpClient.Builder()
      .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
      .build()

  private val gson = GsonBuilder().create()
  val retrofit: Retrofit = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okClient)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
}
