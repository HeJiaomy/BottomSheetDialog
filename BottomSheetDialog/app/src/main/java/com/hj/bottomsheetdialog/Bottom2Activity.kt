package com.hj.bottomsheetdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom2.*

class Bottom2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom2)

        val behavior = BottomSheetBehavior.from(timePicker)
        behavior.state = BottomSheetBehavior.STATE_HIDDEN
        show_dialog.setOnClickListener {
            if (behavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                behavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                behavior.state = BottomSheetBehavior.STATE_HIDDEN
            }
        }
    }
}