package com.harunbekcan.easydatepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.harunbekcan.easydatepicker.Constants.DATE_FORMAT
import com.harunbekcan.easydatepicker.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var startDate = Calendar.getInstance()
    private val startDateListener = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dpButtonListener()
    }

    private fun dpButtonListener(){
        binding.dpButton.setOnClickListener {
            EasyDatePicker(this)
                .setDate(startDate)
                .setFormatType(DATE_FORMAT)
                .setListener(startDateListener)
                .show()
        }
    }
}