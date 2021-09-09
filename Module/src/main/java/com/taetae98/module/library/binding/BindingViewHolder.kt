package com.taetae98.module.library.binding

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.taetae98.module.library.base.BaseViewHolder

abstract class BindingViewHolder<T: Any, VB: ViewDataBinding>(
    protected val binding: VB,
    viewLifecycleOwner: LifecycleOwner
) : BaseViewHolder<T>(binding.root) {
    init {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onBindViewHolder(item: T) {
        onBindViewDataBinding()
    }

    protected open fun onBindViewDataBinding() {

    }
}