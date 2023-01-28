package com.example.taskmanagementappnew

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.taskmanagementappnew.databinding.ActivityCreateCardBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*


class CreateCard : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCreateCardBinding
    var db:DatabaseClass?=null
    lateinit var myCalendar: Calendar
    lateinit var dateSetListener: OnDateSetListener
    lateinit var timeSetListener: OnTimeSetListener
    var finalDate=0L
    var finalTime=0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "todo").build()

        binding.createDate.setOnClickListener(this)
        binding.createTime.setOnClickListener(this)
        binding.saveButton.setOnClickListener(this)
       /*   binding.saveButton.setOnClickListener {

              var title = binding.createTitle.text.toString()
              var priority = binding.createPriority.text.toString()
              //   var date=binding.createDate.text.toString()
              var time = binding.createTime.text.toString()*/
              /*              var date=Calendar.getInstance().time
                  val sdf = SimpleDateFormat("dd/MM/yyyy")
            try
            {
                val mDate: Date = sdf.parse(date)
                val timeInMilliseconds = mDate.time
                println("Date in milli :: $timeInMilliseconds")
            }
            catch (e: ParseException)
            {
                e.printStackTrace()
            }*/
              /*     DataObject.setdata(title,priority,date,time)
             //   DataObject.sorttask(date)
                GlobalScope.launch {
                    db!!.dao().insertTask(EntityClass(0,title,priority,date,time))
                }
                var i=Intent(this,MainActivity::class.java)
                startActivity(i)
            }
        }*/
          }
    override fun onClick(v: View?)
    {
       when(v!!.id)
       {
            R.id.create_date->
            {
                setListener()
            }
           R.id.create_time->
           {
              settimelistener()
           }
           R.id.saveButton->
           {
               saveTodo()
           }
       }
    }

    private fun saveTodo() {
        var title = binding.createTitle.text.toString()
        var priority = binding.createPriority.text.toString()
        DataObject.setdata(title,priority,finalDate,finalTime)
        GlobalScope.launch{
            db!!.dao().insertTask(
                EntityClass(
                    title,priority,finalDate,finalTime,0)
            )
        }
       /* GlobalScope.launch(Dispatchers.Main) {
            val id = withContext(Dispatchers.IO) {
             db!!.dao().insertTask(
                    EntityClass(

                    )
                )
            }*/


        var i=Intent(this,MainActivity::class.java)
        startActivity(i)



    }
    private fun settimelistener()
    {
       myCalendar=Calendar.getInstance()
        timeSetListener=TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            myCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay)
            myCalendar.set(Calendar.MINUTE,minute)
            updateTime()
        }
        var timepickerDialog=TimePickerDialog(this,timeSetListener,myCalendar.get(Calendar.HOUR_OF_DAY),
            myCalendar.get(Calendar.MINUTE),false)
        timepickerDialog.show()

    }

    private fun updateTime()
    {
        var myformat="h:mm a"
        var sdf=SimpleDateFormat(myformat)
        finalTime=myCalendar.time.time
        binding.createTime.setText(sdf.format(myCalendar.time))
    }

    private fun setListener() {
       myCalendar=Calendar.getInstance()
        dateSetListener=DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateDate()
        }

        var datePickerdialog=DatePickerDialog(this,dateSetListener,myCalendar.get(Calendar.YEAR)
            ,myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH))
        datePickerdialog.datePicker.minDate=System.currentTimeMillis()
        datePickerdialog.show()
    }

    private fun updateDate()
    {
        val myformat = "EEE, d MMM yyyy"
        var sdf=SimpleDateFormat(myformat)
        finalDate=myCalendar.time.time
        binding.createDate.setText(sdf.format(myCalendar.time))
    }
}



