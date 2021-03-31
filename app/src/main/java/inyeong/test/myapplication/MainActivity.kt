package inyeong.test.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import java.util.*

class MainActivity : AppCompatActivity(), OnDateSelectedListener {

    lateinit var materialCalendarView: MaterialCalendarView

    lateinit var tvMonday: TextView
    lateinit var tvTuesday: TextView
    lateinit var tvWednesday: TextView
    lateinit var tvThursday: TextView
    lateinit var tvFriday: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        materialCalendarView = findViewById(R.id.cv_calendar)
        materialCalendarView.setOnDateChangedListener(this)

        tvMonday = findViewById(R.id.monday)
        tvTuesday = findViewById(R.id.tuesday)
        tvWednesday = findViewById(R.id.wednesday)
        tvThursday = findViewById(R.id.thursday)
        tvFriday = findViewById(R.id.friday)
    }

    override fun onDateSelected(
        widget: MaterialCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {

        val calendar = Calendar.getInstance()
        calendar.set(date.year,date.month,date.day)
        val dayOfWeek = calendar[Calendar.DAY_OF_WEEK]

        selectWeek(date, dayOfWeek)
    }

    private fun selectWeek(date : CalendarDay, dayOfWeek : Int){

        Log.d("===========",dayOfWeek.toString())
        when (dayOfWeek) {
             4 -> { // monday
                materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day),CalendarDay.from(date.year, date.month, date.day+4))
            }
            5 -> { // TUESDAY
                materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day-1),CalendarDay.from(date.year, date.month, date.day+3))
            }
            6 -> { //WEDNESDAY
                materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day-2),CalendarDay.from(date.year, date.month, date.day+2))
            }
            7 -> { // THURSDAY
                materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day-3),CalendarDay.from(date.year, date.month, date.day+1))
            }
            1 -> { // FRIDAY
                materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day-4),CalendarDay.from(date.year, date.month, date.day))
            }
            2 -> { // satur
              //  materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day-5),CalendarDay.from(date.year, date.month, date.day-1))
            }
            3 -> { // sun
              //  materialCalendarView.selectRange(CalendarDay.from(date.year, date.month, date.day+1),CalendarDay.from(date.year, date.month, date.day+5))
            }
        }



        // 텍스트 표시
        var list : List<CalendarDay> = materialCalendarView.selectedDates

        for ((index,item) in list.withIndex()){
            when(index){
                0->{
                    tvMonday.text = item.month.toString() + "월"+ item.day.toString() + "일" + "월"
                }
                1->{
                    tvTuesday.text = item.month.toString() + "월"+ item.day.toString() + "일" + "화"
                }
                2->{
                    tvWednesday.text = item.month.toString() + "월"+ item.day.toString() + "일" + "수"
                }
                3->{
                    tvThursday.text = item.month.toString() + "월"+ item.day.toString() + "일" + "목"
                }
                4->{
                    tvFriday.text = item.month.toString() + "월"+ item.day.toString() + "일" + "금"
                }

            }
        }

    }

}
