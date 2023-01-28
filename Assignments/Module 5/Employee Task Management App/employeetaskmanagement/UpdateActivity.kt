package com.example.employeetaskmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.employeetaskmanagement.databinding.ActivityProjectDashboardBinding
import com.example.employeetaskmanagement.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbhelperProject: DbHelper
    var id=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbhelperProject=DbHelper(applicationContext)
        var i1=intent
        id=i1.getIntExtra("id1",101)
        binding.uedttitle.setText(i1.getStringExtra("title1"))
        binding.uedtdesc.setText(i1.getStringExtra("desc1"))
        Toast.makeText(applicationContext,""+id, Toast.LENGTH_LONG).show()

        binding.btnupdate.setOnClickListener {
            var utitle=binding.uedttitle.text.toString()
            var udesc=binding.uedtdesc.text.toString()

            var m=Model_project()
            m.id=id
            m.title=utitle
            m.desc=udesc

            dbhelperProject.updateproject(m)
            startActivity(Intent(applicationContext,ProjectDashboard::class.java))
        }
    }
}