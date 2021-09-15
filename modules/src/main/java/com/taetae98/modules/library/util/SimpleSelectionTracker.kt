package com.taetae98.modules.library.util

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView

class SimpleSelectionTracker(
    private val recyclerView: RecyclerView,
    private val gesture: Gesture = Gesture.LONG_CLICK
) {
    val instance by lazy {
        SelectionTracker.Builder(
            "com.taetae98.modules.library.util.SimpleSelectionTracker",
            recyclerView,
            StableIdKeyProvider(recyclerView),
            SimpleItemDetailsLookup(recyclerView, gesture),
            StorageStrategy.createLongStorage()
        ).build()
    }

    class SimpleItemDetailsLookup(
        private val recyclerView: RecyclerView,
        private val gesture: Gesture
    ) : ItemDetailsLookup<Long>() {
        override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
            val child = recyclerView.findChildViewUnder(e.x, e.y) ?: return null
            val holder = recyclerView.getChildViewHolder(child) ?: return null

            return object : ItemDetails<Long>() {
                override fun getPosition(): Int {
                    return holder.bindingAdapterPosition
                }

                override fun getSelectionKey(): Long {
                    return holder.itemId
                }

                override fun inSelectionHotspot(e: MotionEvent): Boolean {
                    return if (gesture == Gesture.CLICK) {
                        return e.actionMasked == MotionEvent.ACTION_UP
                    } else {
                        super.inSelectionHotspot(e)
                    }
                }
            }
        }
    }

    enum class Gesture {
        CLICK, LONG_CLICK
    }
}