package com.example.myapplication

import Communicator
import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_action.*
import kotlinx.android.synthetic.main.fragment_fragment_action.view.*

class FragmentAction : Fragment() {
    lateinit var communicator: Communicator;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_fragment_action, container, false)
        communicator = activity as Communicator;

        root.text_editor.setText(arguments?.getString("returnedText"))

        root.check_btn.setOnClickListener() {

            var edit_text: String = text_editor!!.text.toString()
            if(!first_var.isChecked && !second_var.isChecked && !third_var.isChecked && !forth_var.isChecked || edit_text == "") {
               communicator.passData("Type any text and choose it's size", 50F)
            } else {
                if (first_var.isChecked) {
                    communicator.passData(edit_text, 40F)
                } else if (second_var.isChecked) {
                    communicator.passData(edit_text, 60F)
                } else if (third_var.isChecked) {
                    communicator.passData(edit_text, 80F)
                } else if (forth_var.isChecked) {
                    communicator.passData(edit_text, 100F)
                }
            }


        }

        root.clear_btn.setOnClickListener() {
            root.radio_group.clearCheck();
            text_editor.setText("")
        }

        return root
    }

}
