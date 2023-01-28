package com.example.employeetaskmanagement

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import java.io.ByteArrayOutputStream



class ProfileActivity : AppCompatActivity()
{
    lateinit  var imageViewPPSave: ImageView
    lateinit var imageViewPPShow: ImageView
    lateinit var buttonPPSave: Button
    lateinit var buttonPPShow: Button
    lateinit var factory: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        imageViewPPSave = findViewById(R.id.imageViewMainActivityPPSave)
        buttonPPSave = findViewById(R.id.buttonMainActivityPPSave)
        imageViewPPShow = findViewById(R.id.imageViewMainActivityPPShow)
        buttonPPShow = findViewById(R.id.buttonMainActivityPPShow)
        imageViewPPSave.setOnClickListener(View.OnClickListener { chooseProfilePicture() })
        buttonPPSave.setOnClickListener({ saveUser() })
        buttonPPShow.setOnClickListener( { showUser() })
    }

    private fun saveUser()
    {
        val bytesPP = convertImageViewToByteArray(imageViewPPSave)
        factory = DbHelper(this)
        val user: User? = factory.getUser("SELECT id, pp FROM user WHERE id=1;")
        if (user == null)
        {
            if (factory.save(1, bytesPP)) Toast.makeText(this, "successfully saved", Toast.LENGTH_SHORT).show()
        }
        else
        {
            if (factory.update(1, bytesPP)) Toast.makeText(this, "successfully updated", Toast.LENGTH_SHORT).show()
        }
    }

    private fun convertImageViewToByteArray(imageView: ImageView?): ByteArray
    {
        val bitmap = (imageView!!.drawable as BitmapDrawable).bitmap
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }

    private fun showUser() {
        factory = DbHelper(this)
        val user: User? = factory.getUser("SELECT id, pp FROM user WHERE id=1;")
        if (user != null)
        {
            val bitmap = convertByteArrayToBitmap(user.pp)
            imageViewPPShow!!.setImageBitmap(bitmap)
        }
    }

    private fun convertByteArrayToBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    private fun chooseProfilePicture()
    {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView: View = inflater.inflate(R.layout.alert_dialog_profile_picture, null)
        builder.setCancelable(false)
        builder.setView(dialogView)
        val imageViewADPPCamera = dialogView.findViewById<ImageView>(R.id.imageViewADPPCamera)
        val imageViewADPPGallery = dialogView.findViewById<ImageView>(R.id.imageViewADPPGallery)
        val alertDialogProfilePicture = builder.create()
        alertDialogProfilePicture.show()

        imageViewADPPCamera.setOnClickListener {
            if (checkAndRequestPermissions()) {
                takePictureFromCamera()
                alertDialogProfilePicture.cancel()
            }
        }
        imageViewADPPGallery.setOnClickListener {
            takePictureFromGallery()
            alertDialogProfilePicture.cancel()
        }
    }

    private fun takePictureFromGallery() {
        val pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhoto, 1)
    }

    private fun takePictureFromCamera() {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePicture.resolveActivity(packageManager) != null) {
            startActivityForResult(takePicture, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val selectedImageUri = data!!.data
                imageViewPPSave!!.setImageURI(selectedImageUri)
            }
            2 -> if (resultCode == RESULT_OK) {
                val bundle = data!!.extras
                val bitmapImage = bundle!!["data"] as Bitmap?
                imageViewPPSave!!.setImageBitmap(bitmapImage)
            }
        }
    }

    private fun checkAndRequestPermissions(): Boolean
    {
        if (Build.VERSION.SDK_INT >= 23) {
            val cameraPermission =
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            if (cameraPermission == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    20
                )
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 20 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePictureFromCamera()
        } else Toast.makeText(this, "Permission not Granted", Toast.LENGTH_SHORT)
            .show()
    }
}