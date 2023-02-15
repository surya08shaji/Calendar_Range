package com.example.calendarrange

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calendarrange.databinding.ActivityMainBinding
import com.example.calendarrange.model.CalendarEvent
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eventsList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            listOf(
                CalendarEvent(
                    eventName = "event  1",
                    eventDescription = "event 1 desc",
                    date = Calendar.getInstance().time
                ),
                CalendarEvent(
                    eventName = "event  2",
                    eventDescription = "event 2 desc",
                    date = Calendar.Builder().setDate(2021, 8, 19).build().time
                ),
                CalendarEvent(
                    eventName = "event  3",
                    eventDescription = "event 3 desc",
                    date = Calendar.Builder().setDate(2021, 8, 1).build().time
                ),
                CalendarEvent(
                    eventName = "event  4",
                    eventDescription = "event 4 desc",
                    date = Calendar.Builder().setDate(2021, 11, 10).build().time
                ),
                CalendarEvent(
                    eventName = "event  5",
                    eventDescription = "event 5 desc",
                    date = Calendar.Builder().setDate(2021, 0, 29).build().time
                ),
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        addEvents()

        binding.calendarPicker.eventDotColor = Color.CYAN
        binding.calendarPicker.eventDotColorWhenSelected = Color.RED
        binding.calendarPicker.eventDotColorWhenHighlighted = Color.GREEN
        binding.calendarPicker.setFirstSelectedDate(year = 2021, month = 8, day = 9)
        binding.calendarPicker.setSecondSelectedDate(year = 2021, month = 8, day = 19)

        binding.calendarPicker.initCalendar()

        binding.getDateRangeButton.setOnClickListener {
            val selectedDates = binding.calendarPicker.getSelectedDates()

            if (selectedDates != null) {
                val firstDate = DateFormat.getDateInstance().format(Date(selectedDates.first))
                val secondDate = DateFormat.getDateInstance().format(Date(selectedDates.second))
                Toast.makeText(
                    applicationContext,
                    "Date range from $firstDate to $secondDate",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

private fun addEvents() {

}
