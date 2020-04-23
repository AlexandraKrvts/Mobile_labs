package com.example.myapplication

import Communicator
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_result.view.*

class FragmentResult : Fragment() {
    var text: String? = ""
    var size: Float? = 0F
    lateinit var communicator: Communicator;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater!!.inflate(R.layout.fragment_fragment_result, container, false)
        communicator = activity as Communicator;
        text = arguments?.getString("text")
        size = arguments?.getFloat("size")
        root.text_result.text = text

        root.text_result.setTextSize(TypedValue.COMPLEX_UNIT_PX, size as Float)

        root.back_btn.setOnClickListener() {
            if(text !== "Type any text and choose it's size") {
              communicator.returnFun(text as String)
            } else {
                communicator.returnFun("")
            }
        }

        return root
    }

}
