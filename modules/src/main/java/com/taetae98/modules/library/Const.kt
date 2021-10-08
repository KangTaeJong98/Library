package com.taetae98.modules.library

import android.content.res.Resources
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

fun Int.toDP(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Float.toDP(): Float {
    return (this * Resources.getSystem().displayMetrics.density)
}

fun Bitmap.toByteArray(format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG, quality: Int = 100): ByteArray {
    return toByteArrayOutputStream(format, quality).toByteArray()
}

fun Bitmap.toByteArrayOutputStream(format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG, quality: Int = 100): ByteArrayOutputStream {
    return ByteArrayOutputStream().apply {
        compress(format, quality, this)
    }
}