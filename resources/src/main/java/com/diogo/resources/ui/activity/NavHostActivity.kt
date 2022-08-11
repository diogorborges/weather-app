package com.diogo.resources.ui.activity

import android.os.Bundle
import androidx.navigation.findNavController
import com.diogo.resources.R
import com.diogo.resources.databinding.ActivityNavHostBinding
import com.diogo.resources.navigation.NavManager

class NavHostActivity : BaseActivity(R.layout.activity_nav_host) {

    private lateinit var binding: ActivityNavHostBinding

    private val navController by lazy {
        binding.navHostFragment.findNavController()
    }

    private val navManager = NavManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavHostBinding.inflate(layoutInflater)

        initNavManager()
    }

    private fun initNavManager() = navManager.setOnNavEvent {
        navController.navigate(it)
    }

}