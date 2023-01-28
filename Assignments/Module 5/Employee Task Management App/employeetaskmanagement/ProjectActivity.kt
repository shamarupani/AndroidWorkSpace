package com.example.employeetaskmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.employeetaskmanagement.databinding.ActivityDashboardBinding
import com.example.employeetaskmanagement.databinding.ActivityProjectBinding

class ProjectActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityProjectBinding
    lateinit var dbhelperProject: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbhelperProject=DbHelper(applicationContext)

        binding.btninsert.setOnClickListener {
            var title=binding.title.text.toString()
            var description=binding.desc.text.toString()

            var m1=Model_project()
            m1.title=title
            m1.desc=description
            var id=dbhelperProject.insertproject(m1)

            if (id>0)
            {
                Toast.makeText(applicationContext,"Data Inserted", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ProjectDashboard::class.java))
            }
            else
            {
                Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()

            }
        }
    }
}