package com.taetae98.module.library.base

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator

abstract class BaseActivity : AppCompatActivity() {
    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }
}