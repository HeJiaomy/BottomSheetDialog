package com.hj.bottomsheetdialog

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bottom1.*
import kotlinx.android.synthetic.main.activity_main.*

class Bottom1Activity : AppCompatActivity() {

    private lateinit var webView: WebView
    private var TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom1)
        val view = View.inflate(this, R.layout.bottom_sheet_dialog1, null)

        webView = view.findViewById(R.id.webView)
        webView.loadUrl("https://www.baidu.com")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        val behavior = BottomSheetBehavior.from(view.parent as View)

        behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
                //拖拽中的回调
                Log.e(TAG, "拖拽距离：$p1")
            }

            override fun onStateChanged(p0: View, p1: Int) {
                //状态的改变
                Log.e(TAG, "状态改变：$p1")
                //可以将bottomSheet的高度手动计算，设置为屏幕高度的一半。这里假设为1000
                behavior.peekHeight = 1000

                //隐藏时，销毁dialog
                if (p1 == BottomSheetBehavior.STATE_HIDDEN) {
                    dialog.dismiss()
                }
            }
        })

        show_dialog.setOnClickListener {
            //显示屏幕的一半
            behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            dialog.show()
        }
    }
}