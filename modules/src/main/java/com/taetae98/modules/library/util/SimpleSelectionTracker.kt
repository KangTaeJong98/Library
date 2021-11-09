package com.taetae98.modules.library.util

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SimpleSelectionTracker(
    val recyclerView: RecyclerView,
    val mode: Mode = Mode.LONG_CLICK,
    val maxLength: Int = NO_LENGTH_LIMIT
) {
    companion object {
        private const val ID = "com.taetae98.modules.library.util.SimpleSelectionTracker"

        const val NO_LENGTH_LIMIT = -1
    }

    val instance by lazy {
        SelectionTracker.Builder(
            ID,
            recyclerView,
            SimpleItemKeyProvider(this),
            SimpleItemDetailLookup(this),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SimpleSelectionPredicate(this)
        ).build()
    }

    private class SimpleItemKeyProvider(
        private val tracker: SimpleSelectionTracker
    ) : ItemKeyProvider<Long>(SCOPE_MAPPED) {
        override fun getKey(position: Int): Long? {
            return tracker.recyclerView.findViewHolderForAdapterPosition(position)?.itemId
        }

        override fun getPosition(key: Long): Int {
            val holder = tracker.recyclerView.findViewHolderForItemId(key) ?: return RecyclerView.NO_POSITION
            return holder.bindingAdapterPosition
        }
    }

    private class SimpleItemDetailLookup(
        private val tracker: SimpleSelectionTracker
    ) : ItemDetailsLookup<Long>() {
        override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
            val view = tracker.recyclerView.findChildViewUnder(e.x, e.y) ?: return null
            val holder = tracker.recyclerView.getChildViewHolder(view) ?: return null

            return object : ItemDetails<Long>() {
                override fun getPosition(): Int {
                    return holder.bindingAdapterPosition
                }

                override fun getSelectionKey(): Long {
                    return holder.itemId
                }

                override fun inSelectionHotspot(e: MotionEvent): Boolean {
                    return if (tracker.mode == Mode.LONG_CLICK) {
                        super.inSelectionHotspot(e)
                    } else {
                        e.actionMasked == MotionEvent.ACTION_UP
                    }
                }
            }
        }
    }

    private class SimpleSelectionPredicate(
        private val tracker: SimpleSelectionTracker
    ) : SelectionTracker.SelectionPredicate<Long>() {
        private val queue by lazy { LinkedList<Long>() }

        override fun canSetStateForKey(key: Long, nextState: Boolean): Boolean {
            if (tracker.maxLength == NO_LENGTH_LIMIT) {
                return true
            }

            execute(key, nextState)
            return true
        }

        override fun canSetStateAtPosition(position: Int, nextState: Boolean): Boolean {
            if (tracker.maxLength == NO_LENGTH_LIMIT) {
                return true
            }

            val key = tracker.recyclerView.findViewHolderForAdapterPosition(position)?.itemId ?: return false
            execute(key, nextState)
            return true
        }

        override fun canSelectMultiple(): Boolean {
            return tracker.maxLength > 1 || tracker.maxLength == NO_LENGTH_LIMIT
        }

        private fun execute(key: Long, boolean: Boolean) {
            if (boolean) {
                if (queue.size == tracker.maxLength) {
                    tracker.instance.deselect(queue.pop())
                }

                queue.add(key)
            } else {
                queue.remove(key)
            }
        }
    }


    enum class Mode {
        CLICK, LONG_CLICK
    }
}