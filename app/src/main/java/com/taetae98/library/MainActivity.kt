package com.taetae98.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taetae98.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}