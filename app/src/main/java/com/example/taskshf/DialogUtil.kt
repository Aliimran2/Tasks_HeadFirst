package com.example.taskshf

import android.app.AlertDialog
import android.content.Context

object DialogUtil {
    fun showConfirmationDialog(
        context: Context,
        title: String,
        message: String,
        onConfirm:() -> Unit,
        onCancel: () -> Unit
        ){

        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Yes"){_,_ ->
                onConfirm()
            }
            .setNegativeButton("Cancel"){_,_ ->
                onCancel()
            }.show()
    }
}