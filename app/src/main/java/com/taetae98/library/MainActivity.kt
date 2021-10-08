package com.taetae98.library

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.taetae98.library.databinding.ActivityMainBinding
import com.taetae98.modules.library.navigation.NavigationActivity
import com.taetae98.modules.library.util.PermissionManager

class MainActivity : NavigationActivity<ActivityMainBinding>(R.layout.activity_main, R.id.nav_host) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PermissionManager.Builder(this)
            .setOnGranted {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            .setOnDenied {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
            .execute(arrayOf(Manifest.permission.CAMERA))
    }
}