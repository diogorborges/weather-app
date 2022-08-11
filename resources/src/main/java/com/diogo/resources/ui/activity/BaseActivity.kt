package com.diogo.resources.ui.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes

abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : InjectionActivity(contentLayoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }
}