package com.harunbekcan.easydatepicker

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import com.harunbekcan.easydatepicker.Constants.DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

class EasyDatePicker(
    private val activity: Activity,
    private var style: Int = R.style.DefaultDatePickerStyle,
    private var pattern:String = DATE_FORMAT,
    private var listener: DateSelectListener? = null
) {

    fun setDatePickerStyle(style:Int):EasyDatePicker{
        this.style = style
        return this
    }

    fun setListener(listener: DateSelectListener):EasyDatePicker{
        this.listener = listener
        return this
    }

    fun setFormatType(type:String):EasyDatePicker{
        this.pattern = type
        return this
    }

    fun show(context: Context){
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR) // Current Year
        val month = calendar.get(Calendar.MONTH) // Current Month
        val day = calendar.get(Calendar.DAY_OF_MONTH) // Current Day

        val datePicker = DatePickerDialog(
            this.activity, this.style,
            { _, year, month, dayOfMonth ->

                val formatDate = SimpleDateFormat(pattern, Locale.getDefault())

                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                try {
                    val formattedDate = formatDate.format(calendar.time)
                    listener?.isSelected(formattedDate)
                }catch (e:Exception){
                    Log.e(context.getString(R.string.log_tag_format_exception),"${e.message}")
                }

            }, year, month, day
        )
        try {
            datePicker.show()
        }catch (e: Exception){
            Log.d(context.getString(R.string.log_tag_message), "${e.message}")
        }
    }
}