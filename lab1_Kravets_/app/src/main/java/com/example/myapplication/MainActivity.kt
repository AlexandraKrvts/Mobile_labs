package com.example.myapplication

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Size
import android.util.SizeF
import android.util.TypedValue
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        check_btn.setOnClickListener() {
            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            @Suppress("DEPRECATION")
            vibratorService.vibrate(100)
            if(!first_var.isChecked && !second_var.isChecked && !third_var.isChecked && !forth_var.isChecked) {
                test_view.setTextColor(Color.parseColor("#D8300C"))
                test_view.text = "Choose your variant"
                test_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, 55F);
            } else {
                test_view.setTextColor(Color.parseColor("#2BB921"))
                if (first_var.isChecked) {
                    test_view.text = text_editor.text
                    test_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40F)
                } else if (second_var.isChecked) {
                    test_view.text = text_editor.text
                    test_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, 60F)
                } else if (third_var.isChecked) {
                    test_view.text = text_editor.text
                    test_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, 80F)
                } else if (forth_var.isChecked) {
                    test_view.text = text_editor.text
                    test_view.setTextSize(TypedValue.COMPLEX_UNIT_PX, 100F)
                }
            }

        }

        clear_btn.setOnClickListener() {

            val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            @Suppress("DEPRECATION")
            vibratorService.vibrate(100)

            radio_group.clearCheck();
            test_view.text = "";
        }

    }
}
