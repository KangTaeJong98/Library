package com.taetae98.modules.library.binding

import androidx.databinding.ViewDataBinding
import com.taetae98.modules.library.base.BaseViewHolder

abstract class BindingViewHolder<T: Any, VB: ViewDataBinding>(protected val binding: VB) : BaseViewHolder<T>(binding.root) {
    abstract val itemId: Int

    override fun onBindViewHolder(item: T) {
        super.onBindViewHolder(item)
        binding.setVariable(itemId, item)
    }
}