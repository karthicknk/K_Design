package com.k_design.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import com.k_design.example.R

class DataTimeFragment : Fragment() {

    var textView : TextView? = null
    var timePicker : TimePicker? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.datetime_fragment,container,false)

        textView = view.findViewById<TextView>(R.id.textView)
        timePicker = view.findViewById<TimePicker>(R.id.timePicker)

        OnClickTime()

        return view
    }

    private fun OnClickTime() {

        timePicker!!.setOnTimeChangedListener { _, hour, minute -> var hour = hour
            var am_pm = ""
            // AM_PM decider logic
            when {hour == 0 -> { hour += 12
                am_pm = "AM"
            }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> { hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            if (textView != null) {
                val hour = if (hour < 10) "0" + hour else hour
                val min = if (minute < 10) "0" + minute else minute
                // display format of time
                val msg = "Time is: $hour : $min $am_pm"
                textView!!.text = msg
                textView!!.visibility = ViewGroup.VISIBLE
            }
        }
    }
}