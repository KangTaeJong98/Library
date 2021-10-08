package com.taetae98.modules.library.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    protected val context: Context by lazy { this }
}