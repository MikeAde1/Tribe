package com.example.tribe.ui

import androidx.core.graphics.scaleMatrix
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object Util {
    fun formatDate(dateString: String): String? {
        return try {
            val targetFormat = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
            if (dateString.contains("T")) {
                val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
                targetFormat.format(originalFormat.parse(dateString))
            } else {
                val originalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                targetFormat.format(originalFormat.parse(dateString))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}