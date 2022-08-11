package com.diogo.resources.utils

import android.view.View
import java.lang.StringBuilder
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