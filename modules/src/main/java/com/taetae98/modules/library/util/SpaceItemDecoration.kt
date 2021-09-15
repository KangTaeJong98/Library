package com.taetae98.modules.library.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int
) : RecyclerView.ItemDecoration() {
    constructor(space: Int) : this(space, space, space, space)
    constructor(rect: Rect) : this(rect.left, rect.top, rect.right, rect.bottom)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(left, top, right, bottom)
    }
}