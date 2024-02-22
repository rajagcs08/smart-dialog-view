package com.example.skinneddialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import dev.rajas.libs.smartdialogview.SmartAlertDialog
import dev.rajas.libs.smartdialogview.buttons.NegativeButton
import dev.rajas.libs.smartdialogview.buttons.NeutralButton
import dev.rajas.libs.smartdialogview.buttons.PositiveButton
import dev.rajas.libs.smartdialogview.enum.DialogCategory
import dev.rajas.libs.smartdialogview.enum.DialogPosition
import dev.rajas.libs.smartdialogview.enum.DialogStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showSuccessPopup = findViewById<AppCompatTextView>(R.id.uiSuccessPopup)
        val uiErrorPopup = findViewById<AppCompatTextView>(R.id.uiErrorPopup)
        val uiWarningPopup = findViewById<AppCompatTextView>(R.id.uiWarningPopup)
        val uiInformationPopup = findViewById<AppCompatTextView>(R.id.uiInformationPopup)
        showSuccessPopup.setOnClickListener{
            SmartAlertDialog.Builder(supportFragmentManager, this)
                .setTitle("Success!!")
                .setContent("Your account has been created successfully, For more detail you can contact your higher management or also you can drop a mail to admin team.")
                .setCancellable(false)
                .setTitleColor(getColor(R.color.black))
                .setContentColor(getColor(R.color.maroon))
                .setDialogPosition(DialogPosition.CENTER)
                .setDialogCategory(DialogCategory.SUCCESS)
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = positiveButtonCLickListener))
                .show()
        }

        uiErrorPopup.setOnClickListener{
            SmartAlertDialog.Builder(supportFragmentManager, this)
                .setTitle("Error!!")
                .setContent("Your account has been created successfully, For more detail you can contact your higher management or also you can drop a mail to admin team.")
                .setCancellable(false)
                .setDialogStyle(DialogStyle.SQUARE)
                .setDialogPosition(DialogPosition.TOP)
                .setDialogCategory(DialogCategory.ERROR)
                .setNegativeButton(NegativeButton(text="Yellow"))
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = positiveButtonCLickListener))
                .show()
        }

        uiWarningPopup.setOnClickListener{
            SmartAlertDialog.Builder(supportFragmentManager, this)
                .setTitle("Warning!!")
                .setContent("Your account has been created successfully, For more detail you can contact your higher management or also you can drop a mail to admin team.")
                .setCancellable(false)
                .setDialogCategory(DialogCategory.WARNING)
                .setNegativeButton(NegativeButton(text="Sky Blue", background = getDrawable(R.drawable.bg_button_round_rect_sky_blue),))
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = positiveButtonCLickListener))
                .show()
        }

        uiInformationPopup.setOnClickListener{
            SmartAlertDialog.Builder(supportFragmentManager, this)
                .setTitle("Information!!")
                .setContent("Your account has been created successfully, For more detail you can contact your higher management or also you can drop a mail to admin team.")
                .setCancellable(false)
                .setDialogStyle(DialogStyle.SQUARE)
                .setDialogCategory(DialogCategory.INFORMATION)
                .setNegativeButton(NegativeButton(text = "Cancel"))
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = positiveButtonCLickListener))
                .show()
        }
    }

    val neutralButtonCLickListener =  View.OnClickListener{
    }

    val positiveButtonCLickListener = View.OnClickListener{
    }
    val negativeButtonCLickListener = View.OnClickListener{

    }
}