package com.maehara08.mobiledeveloperchallenge.entension

import java.util.Date
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue

/**
 * 30分以内ならtrue
 */
fun Date.isWithin30Minutes(date: Date): Boolean {
  val dateTime1 = this.time
  val dateTime2 = date.time
  val diffTime = (dateTime1 - dateTime2).absoluteValue
  val thirtyMinutesTime = TimeUnit.MINUTES.toMillis(30)
  return diffTime < thirtyMinutesTime
}