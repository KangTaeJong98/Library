package com.taetae98.module.binding

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.taetae98.module.base.BaseRecyclerViewAdapter

abstract class BindingRecyclerViewAdapter<T: Any>(
    private val viewLifecycleOwner: LifecycleOwner,
    diffCallback: DiffUtil.ItemCallback<T>
) : BaseRecyclerViewAdapter<T>(diffCallback)