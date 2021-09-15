package com.taetae98.modules.library

import android.content.res.Resources

fun Int.toDP(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Float.toDP(): Float {
    return (this * Resources.getSystem().displayMetrics.density)
}