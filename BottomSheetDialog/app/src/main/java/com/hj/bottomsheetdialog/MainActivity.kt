package com.hj.bottomsheetdialog

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent()
        button1.setOnClickListener {
            intent.setClass(this, Bottom1Activity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            intent.setClass(this, Bottom2Activity::class.java)
            startActivity(intent)
        }
    }

}