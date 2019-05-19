package com.maehara08.mobiledeveloperchallenge.entension

import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * 30分以内ならtrue
 */
fun Date?.isWithin30Minutes(): Boolean {
  if (this == null) return false
  val dateTime1 = this.time
  val dateTime2 = Date().time
  val diffTime = dateTime2 - dateTime1
  val thirtyMinutesTime = TimeUnit.MINUTES.toMillis(30)
  return diffTime < thirtyMinutesTime
}