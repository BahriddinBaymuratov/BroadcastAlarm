package com.example.broadcastalarm

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.DialogFragment
import java.util.*

class TimerPickerFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val min = c.get(Calendar.MINUTE)
        return TimePickerDialog(
            activity,
            activity as TimePickerDialog.OnTimeSetListener?,
            hour,
            min,
            DateFormat.is24HourFormat(
                activity
            )
        )
    }
}