package com.taetae98.modules.library.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerViewAdapter<T: Any>(diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, BaseViewHolder<T>>(diffCallback) {
    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.onBindViewHolder(getItem(position))
    }
}