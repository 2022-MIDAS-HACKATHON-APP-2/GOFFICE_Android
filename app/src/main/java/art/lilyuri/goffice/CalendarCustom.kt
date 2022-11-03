package art.lilyuri.goffice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import art.lilyuri.goffice.databinding.ActivityCalendarBinding
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import java.util.*

class CalendarCustom : AppCompatActivity() {

    private val binding: ActivityCalendarBinding by lazy { ActivityCalendarBinding.inflate(layoutInflater) }
    var startTimeCalendar: Calendar = Calendar.getInstance()
    var endTimeCalendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val currentYear = startTimeCalendar.get(Calendar.YEAR)
        val currentMonth = startTimeCalendar.get(Calendar.MONTH)
        val currentDate = startTimeCalendar.get(Calendar.DATE)


        endTimeCalendar.set(currentMonth-1, currentMonth+1)

        binding.Calendar.state().edit()
            .setFirstDayOfWeek(Calendar.SUNDAY)
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .setMinimumDate(CalendarDay.from(currentYear, currentMonth-1, 1 ))
            .setMaximumDate(CalendarDay.from(currentYear, currentMonth+1, lastMonthDate(currentMonth+2)))
            .commit()

        binding.Calendar.addDecorators(

        )
    }

    private fun lastMonthDate(month: Int):Int{
        return when(month){
            1,3,5,7,8,10,12 -> 31
            4,6,9,11 -> 30
            2-> 28
            else -> 0
        }
    }





}