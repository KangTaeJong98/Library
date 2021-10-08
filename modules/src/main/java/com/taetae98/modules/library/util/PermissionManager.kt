package com.taetae98.modules.library.util

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PermissionManager private constructor(
    activity: AppCompatActivity,
) {
    private var onPrepare: (() -> Unit)? = null
    private var onDenied: ((permissions: Array<String>) -> Unit)? = null
    private var onGranted: ((permissions: Array<String>) -> Unit)? = null
    private var onFinish: (() -> Unit)? = null

    private val request = activity.registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        onDenied?.invoke(
            it.filter { entry ->
                !entry.value
            }.keys.toTypedArray()
        )

        onGranted?.invoke(
            it.filter { entry ->
                entry.value
            }.keys.toTypedArray()
        )

        onFinish?.invoke()
    }

    fun onRequest(permissions: Array<String>) {
        onPrepare?.invoke()
        request.launch(permissions)
    }

    class Builder(activity: AppCompatActivity, @StyleRes styleRes: Int = 0) {
        private val manager = PermissionManager(activity)
        private val dialogBuilder by lazy { AlertDialog.Builder(activity, styleRes) }

        private var positiveButtonText: String? = null

        fun setOnPrepare(onPrepare: (() -> Unit)?): Builder {
            manager.onPrepare = onPrepare
            return this
        }

        fun setOnFinish(onFinish: (() -> Unit)?): Builder {
            manager.onFinish = onFinish
            return this
        }

        fun setOnGranted(onGranted: ((permissions: Array<String>) -> Unit)?): Builder {
            manager.onGranted = onGranted
            return this
        }

        fun setOnDenied(onDenied: ((permissions: Array<String>) -> Unit)?): Builder {
            manager.onDenied = onDenied
            return this
        }

        fun setDialogTitle(title: String): Builder {
            dialogBuilder.setTitle(title)
            return this
        }

        fun setDialogMessage(message: String): Builder {
            dialogBuilder.setMessage(message)
            return this
        }

        fun setPositiveButtonText(text: String): Builder {
            positiveButtonText = text
            return this
        }

        fun setNegativeButton(text: String, listener: ((dialogInterface: DialogInterface, i: Int) -> Unit)? = null): Builder {
            dialogBuilder.setNegativeButton(text, listener)
            return this
        }

        fun execute(permissions: Array<String>, skipDialog: Boolean = true) {
            if (skipDialog) {
                manager.onRequest(permissions)
            } else {
                dialogBuilder
                    .setPositiveButton(positiveButtonText ?: "OK") { _, _ ->
                        manager.onRequest(permissions)
                    }
                    .show()
            }
        }
    }
}