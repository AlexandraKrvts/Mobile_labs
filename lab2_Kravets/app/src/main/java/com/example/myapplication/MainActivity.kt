package com.example.myapplication

import Communicator
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
import androidx.fragment.app.Fragment


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Communicator {
    var manager = supportFragmentManager
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var transaction = manager.beginTransaction()
        val fragment = FragmentAction()
        transaction.replace(R.id.activity_main, fragment)
        transaction.addToBackStack(null);
        transaction.commit();
    }

    override fun passData(text: String, size_text: Float) {
        val bundle = Bundle()
        val transaction = manager.beginTransaction()
        val fragment = FragmentResult()
        bundle.putString("text", text)
        bundle.putFloat("size", size_text)
        fragment.arguments  = bundle;
        transaction.replace(R.id.activity_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun returnFun(text: String) {
        val bundle = Bundle()
        val transaction = manager.beginTransaction()
        val fragment = FragmentAction()
        bundle.putString("returnedText", text)
        fragment.arguments  = bundle;
        transaction.replace(R.id.activity_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
