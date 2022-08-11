package com.diogo.resources.navigation

import androidx.navigation.NavDirections

class NavManager {

    private var navEventListener: ((navDirections: NavDirections) -> Unit)? = null

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }
}