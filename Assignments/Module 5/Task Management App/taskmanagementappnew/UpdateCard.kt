package com.example.taskmanagementappnew

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.taskmanagementappnew.databinding.ActivityUpdateCardBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class UpdateCard : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateCardBinding
    var db: DatabaseClass? = null
    lateinit var myCalendar: Calendar

    var finalDate = 0L
    var finalTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateCardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "todo").build()


        var pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            var title = DataObject.getdata(pos).title
            var priority = DataObject.getdata(pos).priority
            var date = DataObject.getdata(pos).date
            var time = DataObject.getdata(pos).time

            binding.updateTitle.setText(title)
            binding.updatePriority.setText(priority)


            binding.deleteButton.setOnClickListener {
                DataObject.deletedata(pos)
                GlobalScope.launch {
                    db!!.dao().deleteTask(EntityClass(title, priority, finalDate, finalTime))
                }
                myIntent()
            }
            binding.updateButton.setOnClickListener {

                var title = binding.updateTitle.text.toString()
                var priority = binding.updatePriority.text.toString()

                DataObject.updatedata(pos, title, priority, date, time)

                GlobalScope.launch {
                    db!!.dao().updateTask(EntityClass(title, priority, finalDate, finalTime))
                }
                myIntent()
            }
        }
    }
   private  fun bind(EntityClass: EntityClass)
    {
        updateTime(EntityClass.time)
        updateDate(EntityClass.date)
    }
    private fun myIntent() {
        var i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    private fun updateDate(date: Long)
    {
        val myformat = "EEE, d MMM yyyy"
        var sdf=SimpleDateFormat(myformat)
        finalDate=myCalendar.time.time
        binding.updateDate.setText(sdf.format(myCalendar.time))
    }

    private fun updateTime(time: Long)
    {
        var myformat="h:mm a"
        var sdf=SimpleDateFormat(myformat)
        finalTime=myCalendar.time.time
        binding.updateTime.setText(sdf.format(myCalendar.time))
    }


}