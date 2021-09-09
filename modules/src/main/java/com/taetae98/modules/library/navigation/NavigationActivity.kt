package com.taetae98.modules.library.navigation

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.databinding.ViewDataBinding
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.taetae98.modules.library.binding.BindingActivity

abstract class NavigationActivity<VB: ViewDataBinding>(
    @LayoutRes
    layoutRes: Int,
    @IdRes
    navHostId: Int,
) : BindingActivity<VB>(layoutRes) {
    protected val navController by lazy {
        (supportFragmentManager.findFragmentById(navHostId) as NavHostFragment).navController
    }

    protected open val appBarConfiguration by lazy {
        AppBarConfiguration(navController.graph)
    }

    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }
}