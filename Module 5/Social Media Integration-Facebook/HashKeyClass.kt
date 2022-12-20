package com.example.socialmediaintegrationfacebook

import android.app.Application
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class HashKeyClass :Application()
{

        override fun onCreate() {
            super.onCreate()
            printHashKey()
        }

        fun printHashKey() {
            // Add code to print out the key hash
            try
            {
                val info = packageManager.getPackageInfo(
                    "com.example.socialmediaintegrationfacebook",
                    PackageManager.GET_SIGNATURES
                )
                for (signature in info.signatures)
                {
                    val md: MessageDigest = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
                }
            }
            catch (e: PackageManager.NameNotFoundException)
            {
            }
            catch (e: NoSuchAlgorithmException)
            {
            }
        }
    }
