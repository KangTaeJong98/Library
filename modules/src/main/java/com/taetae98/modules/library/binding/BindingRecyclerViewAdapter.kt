package com.taetae98.modules.library.binding

import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.taetae98.modules.library.base.BaseRecyclerViewAdapter

abstract class BindingRecyclerViewAdapter<T: Any>(
    diffCallback: DiffUtil.ItemCallback<T>,
    protected val viewLifecycleOwner: LifecycleOwner? = null
) : BaseRecyclerViewAdapter<T>(diffCallback)