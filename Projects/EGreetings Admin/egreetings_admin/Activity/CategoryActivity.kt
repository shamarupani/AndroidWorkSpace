package com.example.egreetings_admin.Activity


import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.example.egreetings_admin.ApiClient.ApiClient
import com.example.egreetings_admin.Interface.ApiInterface

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import com.example.egreetings_admin.databinding.ActivityCategoryBinding
import net.gotev.uploadservice.MultipartUploadRequest

class CategoryActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCategoryBinding
    lateinit var apiInterface: ApiInterface
    lateinit var filepath:Uri
    lateinit var bitmap: Bitmap

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var i=intent
        var pos= i.getIntExtra("c_pos",101)
        Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()
        if (pos==0)
        {
            apiInterface.diwaliupload
        }
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        requestpermission()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestpermission() {
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),100)
        }
        else
        {
          Toast.makeText(applicationContext,"Permission not granted",Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(p0: View?) {

        if (p0 == binding.btn1)
        {
            var i = intent
            i.type = "image/*"
            i.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(i, "Select Picture"), 1)
        }
        if (p0 == binding.btn2)
        {
            var name=binding.edt1.text.toString()
            var path=getPath(filepath)
            MultipartUploadRequest(this,"https://shamarayani.000webhostapp.com/egreetings_admin/upload.php")
                .addFileToUpload(path,"img")
                .addParameter("name",name)
                .setMaxRetries(2)
                .startUpload()

            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()

        }
    }

    @SuppressLint("Range")
    fun getPath(uri: Uri?): String
    {
        var cursor = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==1 && resultCode== RESULT_OK && data!=null)
        {
            filepath= data.data!!
            bitmap=MediaStore.Images.Media.getBitmap(contentResolver,filepath)
            binding.img.setImageBitmap(bitmap)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}