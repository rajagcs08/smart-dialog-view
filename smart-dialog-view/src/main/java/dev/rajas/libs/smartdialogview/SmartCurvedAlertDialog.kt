package dev.rajas.libs.smartdialogview

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import dev.rajas.libs.smartdialogview.*
import dev.rajas.libs.smartdialogview.buttons.NegativeButton
import dev.rajas.libs.smartdialogview.buttons.NeutralButton
import dev.rajas.libs.smartdialogview.buttons.PositiveButton
import dev.rajas.libs.smartdialogview.enum.DialogCategory
import dev.rajas.libs.smartdialogview.enum.DialogPosition
import dev.rajas.libs.smartdialogview.enum.DialogStyle


internal class SmartCurvedAlertDialog(
    val _context: Context,
    val title: String?,
    val content: String?,
    val titleColor: Int?=0,
    val contentColor: Int?=0,
    val positiveButton: PositiveButton?,
    val negativeButton: NegativeButton?,
    val neutralButton: NeutralButton?,
    val category: DialogCategory? = DialogCategory.INFORMATION,
    val style: DialogStyle? = DialogStyle.CURVED,
    val dialogPosition: DialogPosition? = DialogPosition.BOTTOM,
    var isCancelable: Boolean? = true
) : DialogFragment() {

    val customContext: Context get() = _context
    private lateinit var uiDialogBody: ConstraintLayout
    private lateinit var uiRoundHead: ConstraintLayout
    private lateinit var titleView: AppCompatTextView
    private lateinit var contentView: AppCompatTextView
    private lateinit var uiDialogIcon: AppCompatImageView
    private lateinit var uiIconBackground: AppCompatImageView
    private lateinit var negativeButtonView: AppCompatButton
    private lateinit var positiveButtonView: AppCompatButton
    private lateinit var neutralButtonView: AppCompatButton
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        val builder = AlertDialog.Builder(customContext)
        val inflater = LayoutInflater.from(customContext)
        val view = inflater.inflate(R.layout.dialog_skinned_view, null)
        initDialogViews(view)
        applyStyleToDialog(style)
        applySkinToDialog(category, style)
        setContent()
        setListeners()
        builder.setView(view)
        // Create the AlertDialog with a transparent background
        val alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setDialogPosition(alertDialog)
        alertDialog.setCancelable(isCancelable ?: true)
        alertDialog.setCanceledOnTouchOutside(isCancelable ?: true)
        return alertDialog
    }



    private fun initDialogViews(view: View) {
        uiDialogBody = view.findViewById(R.id.uiDialogBody)
        uiRoundHead = view.findViewById(R.id.uiRoundHead)
        titleView = view.findViewById(R.id.uiDialogTitle)
        contentView = view.findViewById(R.id.uiDialogContent)
        negativeButtonView = view.findViewById(R.id.uiNegativeButton)
        neutralButtonView = view.findViewById(R.id.uiNeutralButton)
        positiveButtonView = view.findViewById(R.id.uiPositiveButton)
        uiIconBackground = view.findViewById(R.id.uiIconBackground)
        uiDialogIcon = view.findViewById(R.id.uiDialogIcon)
    }

    private fun applySkinToDialog(category: DialogCategory?, style: DialogStyle?) {
        when (category) {
            DialogCategory.SUCCESS -> {
                titleView.setTextColor(ContextCompat.getColor(_context,R.color.green))
                uiIconBackground.setBackgroundResource(R.drawable.bg_round_green)
                uiDialogIcon.setImageDrawable(ContextCompat.getDrawable(_context,R.drawable.ic_success_tick))
                if(positiveButton!=null && negativeButton==null && neutralButton==null) {
                    if(style == DialogStyle.SQUARE){
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_round_square_green
                            )
                        )
                    }else {
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_round_rect_green
                            )
                        )
                    }
                }
            }
            DialogCategory.ERROR -> {
                titleView.setTextColor(ContextCompat.getColor(_context,R.color.red))
                uiIconBackground.setBackgroundResource(R.drawable.bg_round_red)
                uiDialogIcon.setImageDrawable(ContextCompat.getDrawable(_context,R.drawable.ic_error_close))
                if(positiveButton!=null && negativeButton==null && neutralButton==null) {
                    if(style == DialogStyle.SQUARE){
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_square_rect_red
                            )
                        )
                    }else {
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_round_rect_red
                            )
                        )
                    }
                }
            }
            DialogCategory.WARNING -> {
                titleView.setTextColor(ContextCompat.getColor(_context,R.color.orange))
                uiIconBackground.setBackgroundResource(R.drawable.bg_round_orange)
                uiDialogIcon.setImageDrawable(ContextCompat.getDrawable(_context,R.drawable.ic_information))
                if(positiveButton!=null && negativeButton==null && neutralButton==null) {

                    if(style == DialogStyle.SQUARE){
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_square_rect_orange
                            )
                        )
                    }else {
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_round_rect_orange
                            )
                        )
                    }
                }
            }
            else -> {
                titleView.setTextColor(ContextCompat.getColor(_context,R.color.blue))
                uiIconBackground.setBackgroundResource(R.drawable.bg_round_blue)
                uiDialogIcon.setImageDrawable(ContextCompat.getDrawable(_context,R.drawable.ic_information))
                if(positiveButton!=null) {
                    if(style == DialogStyle.SQUARE){
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_round_square_blue
                            )
                        )
                    }else {
                        positiveButtonView.setBackgroundDrawable(
                            ContextCompat.getDrawable(
                                _context,
                                R.drawable.bg_button_round_rect_blue
                            )
                        )
                    }
                }

            }
        }
    }

    private fun applyStyleToDialog(style: DialogStyle?) {
        uiRoundHead.background = ContextCompat.getDrawable(_context, R.drawable.bg_round_white)
        if (style == DialogStyle.SQUARE) {
            uiDialogBody.setBackgroundResource(R.drawable.bg_square_rect_white)
        } else {
            uiDialogBody.setBackgroundResource(R.drawable.bg_round_rect_white)
        }
    }

    private fun setContent(){

        if (!title.isNullOrEmpty()) {
            titleView.text = title
            titleColor?.let {color->
                if(color!=0)
                titleView.setTextColor(color)
            }

        }else titleView.visibility = View.GONE

        if (!content.isNullOrEmpty()) {
            contentView.text = content
            contentColor?.let { color->
                if(color!=0)
                    contentView.setTextColor(color)
            }
        }else contentView.visibility = View.GONE

        setupPositiveButton(positiveButton)
        setupNegativeButton(negativeButton)
        setupNeutralButton(neutralButton)
    }

    private fun setupPositiveButton(positiveButton: PositiveButton?) {
        if (positiveButton != null) {
            positiveButtonView.visibility = View.VISIBLE
            positiveButtonView.text = positiveButton.text

            if (positiveButton.background != null) {
                positiveButtonView.setBackgroundDrawable(positiveButton.background)
            }

            if (positiveButton.textColor != 0)
                positiveButtonView.setTextColor(positiveButton.textColor)
        } else
            positiveButtonView.visibility = View.GONE
    }

    private fun setupNegativeButton(negativeButton: NegativeButton?) {
        if (negativeButton != null) {
            negativeButtonView.visibility = View.VISIBLE
            negativeButtonView.text = negativeButton.text

            if (negativeButton.background != null) {
                negativeButtonView.setBackgroundDrawable(negativeButton.background)
            }

            if (negativeButton.textColor != 0)
                negativeButtonView.setTextColor(negativeButton.textColor)
        } else
            negativeButtonView.visibility = View.GONE
    }

    private fun setupNeutralButton(neutralButton: NeutralButton?) {
        if (neutralButton != null) {
            neutralButtonView.visibility = View.VISIBLE
            neutralButtonView.text = neutralButton.text

            if (neutralButton.background != null) {
                neutralButtonView.setBackgroundDrawable(neutralButton.background)
            }

            if (neutralButton.textColor != 0)
                neutralButtonView.setTextColor(neutralButton.textColor)
        } else
            neutralButtonView.visibility = View.GONE
    }

    private fun setListeners() {
        negativeButtonView.setOnClickListener{
            negativeButton?.onClickListener?.onClick(it)
            dismiss()
        }
        positiveButtonView.setOnClickListener{
            positiveButton?.onClickListener?.onClick(it)
            dismiss()
        }
        neutralButtonView.setOnClickListener{
            neutralButton?.onClickListener?.onClick(it)
            dismiss()
        }
    }

    private fun setDialogPosition(alertDialog: AlertDialog) {
        val window = alertDialog.window
        val params = window?.attributes
        when (dialogPosition) {
            DialogPosition.CENTER -> params?.gravity = Gravity.CENTER
            DialogPosition.TOP -> params?.gravity = Gravity.TOP
            else -> params?.gravity = Gravity.BOTTOM
        }
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = params
    }
}