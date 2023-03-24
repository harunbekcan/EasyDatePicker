package com.harunbekcan.easydatepicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.harunbekcan.easydatepicker.Constants.DATE_FORMAT

class MainActivity : AppCompatActivity() {
    var myDatePickerDialog : EasyDatePicker?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDatePickerDialog = EasyDatePicker(this)
                .setFormatType(DATE_FORMAT)
                .setListener(object : DateSelectListener {
                    override fun isSelected(date: String) {
                        Toast.makeText(applicationContext,date, Toast.LENGTH_SHORT).show()
                    }
                })
    }
}