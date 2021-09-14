package com.taetae98.modules.library.binding

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.taetae98.modules.library.base.BaseViewHolder

abstract class BindingViewHolder<T: Any, VB: ViewDataBinding>(
    protected val binding: VB,
    viewLifecycleOwner: LifecycleOwner? = null
) : BaseViewHolder<T>(binding.root) {
    init {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun onBindViewHolder(item: T) {
        super.onBindViewHolder(item)
        onBindViewDataBinding()
    }

    protected open fun onBindViewDataBinding() {

    }
}