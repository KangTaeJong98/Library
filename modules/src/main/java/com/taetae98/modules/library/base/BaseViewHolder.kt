package com.taetae98.modules.library.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected val context: Context
        get() {
            return itemView.context
        }

    open fun onBindViewHolder(item: T) {

    }

    open fun onBindViewHolder(item: T, payload: MutableList<Any>) {

    }
}