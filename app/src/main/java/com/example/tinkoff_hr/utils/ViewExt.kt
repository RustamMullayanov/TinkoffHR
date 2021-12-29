package com.example.tinkoff_hr.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import androidx.annotation.Px
import kotlin.math.roundToInt

fun Activity.dpToPx(dp: Float): Int {
    return dpToPx(dp, this.resources)
}

fun Context.dpToPx(dp: Float): Int {
    return dpToPx(dp, this.resources)
}

@Px
fun dpToPx(dp: Float, resources: Resources): Int {
    return (dp * resources.displayMetrics.density).roundToInt()
}