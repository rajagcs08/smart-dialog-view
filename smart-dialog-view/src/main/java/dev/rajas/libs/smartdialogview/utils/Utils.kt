package dev.rajas.libs.smartdialogview.utils

import android.content.Context
import android.graphics.Color
import android.util.TypedValue


fun Context.getDimension(value: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, value, this.resources.displayMetrics).toInt()
}