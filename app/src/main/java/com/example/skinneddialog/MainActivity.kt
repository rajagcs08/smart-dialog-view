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
                .setContentColor(getColor(R.color.merun))
                .setDialogPosition(DialogPosition.CENTER)
                .setDialogCategory(DialogCategory.SUCCESS)
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = neutralButtonCLickListener))
                .show()
        }

        uiErrorPopup.setOnClickListener{
            SmartAlertDialog.Builder(supportFragmentManager, this)
                .setTitle("Error!!")
                .setContent("Your account has been created successfully, For more detail you can contact your higher management or also you can drop a mail to admin team.")
                .setCancellable(false)
                .setDialogPosition(DialogPosition.TOP)
                .setDialogCategory(DialogCategory.ERROR)
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = neutralButtonCLickListener))
                .show()
        }

        uiWarningPopup.setOnClickListener{
            SmartAlertDialog.Builder(supportFragmentManager, this)
                .setTitle("Warning!!")
                .setContent("Your account has been created successfully, For more detail you can contact your higher management or also you can drop a mail to admin team.")
                .setCancellable(false)
                .setDialogCategory(DialogCategory.WARNING)
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = neutralButtonCLickListener))
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
                .setPositiveButton(PositiveButton(text ="Okay", textColor = getColor(R.color.white), onClickListener = neutralButtonCLickListener))
                .show()
        }
    }

    val neutralButtonCLickListener =  View.OnClickListener{
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
    }

    val positiveButtonCLickListener = View.OnClickListener{
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
    }
    val negativeButtonCLickListener = View.OnClickListener{
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()

    }
}