package com.taetae98.library

import com.taetae98.library.databinding.ActivityMainBinding
import com.taetae98.module.navigation.NavigationActivity

class MainActivity : NavigationActivity<ActivityMainBinding>(
    R.layout.activity_main,
    R.id.nav_host
)