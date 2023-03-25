package com.harunbekcan.easydatepicker

import android.app.Activity
import android.app.DatePickerDialog
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

class EasyDatePicker(private val activity: Activity) {

    private var style: Int? = null
    private var formatType: String? = null
    private var listener: MutableLiveData<String>? = null
    private var editText: EditText? = null
    private var minDate: Calendar? = null
    private lateinit var date: Calendar

    fun setDatePickerStyle(style: Int): EasyDatePicker {
        this.style = style
        return this
    }

    fun setListener(listener: MutableLiveData<String>?): EasyDatePicker {
        this.listener = listener
        return this
    }

    fun setFormatType(type: String): EasyDatePicker {
        this.formatType = type
        return this
    }

    fun setDate(date: Calendar): EasyDatePicker {
        this.date = date
        return this
    }

    fun setMinDate(minDate: Calendar): EasyDatePicker {
        this.minDate = minDate
        return this
    }

    fun setEditText(editText: EditText): EasyDatePicker {
        this.editText = editText
        return this
    }

    fun show() {
        val dpd = DatePickerDialog(
                this.activity, this.style ?: R.style.DefaultDatePickerStyle,
                { _, year, monthOfYear, dayOfMonth ->
                    setCalendarInfo(date, year, monthOfYear, dayOfMonth)
                    updateDialogView(
                        date = date,
                        datePickerEditText = editText
                    )
                },
                date.get(Calendar.YEAR),
                date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH)
            )
        minDate?.let {
            val sdf = SimpleDateFormat(formatType, Locale.US)
            dpd.datePicker.minDate = it.timeInMillis
            editText?.text?.clear()
            listener?.value = sdf.format(date.time)
        }
        dpd.show()
    }

    private fun updateDialogView(
        date: Calendar,
        datePickerEditText: EditText? = null
    ) {
        val sdf = SimpleDateFormat(formatType, Locale.US)
        datePickerEditText?.setText(sdf.format(date.time))
        listener?.value = sdf.format(date.time)
    }

    private fun setCalendarInfo(calendar: Calendar, year: Int, month: Int, day: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)
    }
}