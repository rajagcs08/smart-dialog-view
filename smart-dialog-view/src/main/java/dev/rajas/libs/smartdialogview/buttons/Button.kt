package dev.rajas.libs.smartdialogview.buttons

import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.IntegerRes

data class PositiveButton(var text:String, @ColorInt var textColor: Int=0, var background: Drawable?=null, var onClickListener:View.OnClickListener?=null)
data class NegativeButton(var text:String, @ColorInt var textColor: Int=0, var background: Drawable?=null, var onClickListener: View.OnClickListener?=null)
data class NeutralButton(var text:String, @ColorInt var textColor: Int=0, var background: Drawable?=null, var onClickListener:View.OnClickListener?=null)
