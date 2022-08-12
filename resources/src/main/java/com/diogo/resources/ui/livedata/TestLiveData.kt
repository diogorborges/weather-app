package com.diogo.resources.ui.livedata

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.StateFlow

fun <T> LiveData<T>.observeForeverTo(list: MutableList<T>) = apply {
    observeForever { list.add(it) }
}