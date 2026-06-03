package com.example.my_coffee_app.ui_components

import android.R.attr.title
import android.R.id.message
import android.app.ProgressDialog.show
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppMessageDialogue(
    show: Boolean,
    title: String,
    message: String,
    onDismiss: () -> Unit,
) {
    if(show){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = title)},
            text = { Text(text = message)},
            confirmButton = { TextButton(onClick = onDismiss){Text(text = "OK")}}
        )
    }
}
