package com.maehara08.mobiledeveloperchallenge.reposiotry

import android.content.Context
import android.view.View
import com.maehara08.mobiledeveloperchallenge.R
import com.maehara08.mobiledeveloperchallenge.helper.SnackbarHelper
import com.maehara08.mobiledeveloperchallenge.helper.ToastHelper
import kotlinx.coroutines.Deferred
import timber.log.Timber
import java.net.UnknownHostException

object Network {
  suspend fun <T> request(
    rootView: View,
    call: Deferred<T>,
    success: ((response: T) -> Unit)?,
    fail: ((throwable: Throwable) -> Unit)? = null
  ) {
    try {
      success?.invoke(call.await())
    } catch (t: Throwable) {
      Timber.e(t)
      when (t) {
        is UnknownHostException -> {
          SnackbarHelper.show(rootView, R.string.error_message_network_error)
        }
        else -> {
          fail?.invoke(t)
        }
      }
    }
  }

  suspend fun <T> request(
    context: Context,
    call: Deferred<T>,
    success: ((response: T) -> Unit)?,
    fail: ((throwable: Throwable) -> Unit)? = null
  ) {
    try {
      success?.invoke(call.await())
    } catch (t: Throwable) {
      Timber.e(t)
      when (t) {
        is UnknownHostException -> {
          ToastHelper.show(context, R.string.error_message_network_error)
        }
        else -> {
          fail?.invoke(t)
        }
      }
    }
  }
}