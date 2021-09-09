package com.taetae98.module.library.binding

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.taetae98.module.library.base.BaseActivity

abstract class BindingActivity<VB: ViewDataBinding>(
    @LayoutRes
    layoutRes: Int
) : BaseActivity() {
    protected val binding: VB by lazy {
        DataBindingUtil.setContentView(this, layoutRes)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateViewDataBinding()
    }

    protected open fun onCreateViewDataBinding() {
        binding.lifecycleOwner = this
    }
}