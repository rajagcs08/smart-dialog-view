package dev.rajas.libs.smartdialogview

import android.content.Context
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentManager
import dev.rajas.libs.smartdialogview.buttons.NegativeButton
import dev.rajas.libs.smartdialogview.buttons.NeutralButton
import dev.rajas.libs.smartdialogview.buttons.PositiveButton
import dev.rajas.libs.smartdialogview.enum.DialogCategory
import dev.rajas.libs.smartdialogview.enum.DialogPosition
import dev.rajas.libs.smartdialogview.enum.DialogStyle

class SmartAlertDialog {

    class Builder(private var fragmentManager:FragmentManager, private var _context: Context){

        private var title:String?=null
        private var content:String?=null
        private var titleColor: Int?=null
        private var contentColor:Int?=null
        private var backgroundColor:Int?=null
        private var positiveButton: PositiveButton?=null
        private var negativeButton: NegativeButton?=null
        private var neutralButton: NeutralButton?=null
        private var category: DialogCategory?=DialogCategory.INFORMATION
        private var style: DialogStyle?=DialogStyle.CURVED
        private var dialogPosition:DialogPosition?=DialogPosition.BOTTOM
        private var isCancelable:Boolean ?= true

        fun setTitle(title:String):Builder{
            this.title = title
            return this
        }

        fun setContent(content:String):Builder{
            this.content = content
            return this
        }

        fun setTitleColor(@ColorInt titleColor: Int):Builder{
            this.titleColor = titleColor
            return this
        }

        fun setContentColor(@ColorInt contentColor: Int):Builder{
            this.contentColor = contentColor
            return this
        }

//        fun setBackgroundColor(@ColorInt backgroundColor: Int):Builder{
//            this.backgroundColor = backgroundColor
//            return this
//        }

        fun setPositiveButton(positiveButton: PositiveButton):Builder{
            this.positiveButton = positiveButton
            return this
        }

        fun setNegativeButton(negativeButton: NegativeButton):Builder{
            this.negativeButton = negativeButton
            return this
        }


        fun setNeutralButton(neutralButton: NeutralButton):Builder{
            this.neutralButton = neutralButton
            return this
        }

        fun setDialogCategory(category: DialogCategory):Builder{
            this.category = category
            return this
        }

        fun setDialogStyle(style: DialogStyle):Builder{
            this.style = style
            return this
        }

        fun setDialogPosition(dialogPosition: DialogPosition):Builder{
            this.dialogPosition = dialogPosition
            return this
        }
        fun setCancellable(isCancelable: Boolean):Builder{
            this.isCancelable = isCancelable
            return this
        }

        fun show(){
            val bottomSheetFragment = SmartCurvedAlertDialog(
                _context = _context,
                title = title,
                content = content,
                titleColor = titleColor,
                contentColor = contentColor,
                positiveButton = positiveButton,
                negativeButton = negativeButton,
                neutralButton = neutralButton,
                category = category,
                style = style,
                dialogPosition = dialogPosition,
                isCancelable = isCancelable
            )
            bottomSheetFragment.show(fragmentManager, bottomSheetFragment.tag)
        }
    }

}