package com.example.inventorymananagementapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.inventorymananagementapp.databinding.ActivityQrcodeScannBinding
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONException
import org.json.JSONObject

class QrcodeScannActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityQrcodeScannBinding
    private var qrScanIntegrator: IntentIntegrator? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrcodeScannBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setOnClickListener()
        setupScanner()

    }
        private fun setOnClickListener() {
            binding.btnScan.setOnClickListener { performAction() }


        }
        private fun setupScanner() {
            qrScanIntegrator = IntentIntegrator(this)
            qrScanIntegrator?.setOrientationLocked(false)

        }

        private fun performAction() {
            // Code to perform action when button is clicked.
            qrScanIntegrator?.initiateScan()
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                // If QRCode has no data.
                if (result.contents == null) {
                    Toast.makeText(this, getString(R.string.result_not_found), Toast.LENGTH_LONG).show()
                } else {
                    // If QRCode contains data.
                    try {
                        // Converting the data to json format
                        val obj = JSONObject(result.contents)

                        // Show values in UI.
                        binding.name.text = obj.getString("barcode")
                        binding.siteName.text = obj.getString("name")
                        binding.sitePrice.text = obj.getString("price")
                        binding.siteCategory.text = obj.getString("category")

                    } catch (e: JSONException) {
                        e.printStackTrace()

                        // Data not in the expected format. So, whole object as toast message.
                        Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }

    }
