package com.diogo.resources.utils

import android.content.Context
import android.view.View
import com.diogo.resources.R
import java.lang.StringBuilder
import java.util.*
import kotlin.math.pow

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

val Date.toCalendar: Calendar
    get() = Calendar.getInstance().apply {
        this.time = this@toCalendar
    }

fun Calendar.isSameDay(calendar: Calendar): Boolean =
    year == calendar.year && month == calendar.month && dayOfMonth == calendar.dayOfMonth

fun Calendar.getDisplayDate(): String = "${this.dayOfMonth}/${this.month}/${this.year}"

fun Double.getCelsius(context: Context): String = String.format(context.getString(R.string.celsius), this.toInt())

val Calendar.year
    get() = get(Calendar.YEAR)

val Calendar.month
    get() = get(Calendar.MONTH)

val Calendar.dayOfMonth
    get() = get(Calendar.DAY_OF_MONTH)