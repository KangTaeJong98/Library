package com.taetae98.module.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.taetae98.module.base.BaseDialogFragment

abstract class BindingDialogFragment<VB: ViewDataBinding>(
    @LayoutRes
    layoutRes: Int
) : BaseDialogFragment() {
    protected val binding: VB by lazy {
        DataBindingUtil.inflate(layoutInflater, layoutRes, null ,false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        onCreateViewDataBinding()
        return binding.root
    }

    protected open fun onCreateViewDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
    }
}