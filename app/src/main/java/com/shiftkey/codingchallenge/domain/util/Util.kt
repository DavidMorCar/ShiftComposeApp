package com.shiftkey.codingchallenge.domain.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.graphics.Color
import com.shiftkey.codingchallenge.ui.theme.Purple200
import java.lang.Exception

/** Function to open a url */
fun openURL(path: String, activity: Activity) {
    activity.startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(path)
        )
    )
}

/** Function to get a Color from String */
fun getColor(color: String): Color {
    return try {
        Color(android.graphics.Color.parseColor(color))
    } catch (e: Exception) {
        Purple200
    }
}