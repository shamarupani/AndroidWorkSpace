package com.example.firebasecrud.SocialMediaIntegration

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.firebasecrud.R
import com.example.firebasecrud.databinding.ActivityMain2FirebaseBinding
import com.example.firebasecrud.databinding.ActivityMainGoogleBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status

class MainActivity_google : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener
{
    private lateinit var binding: ActivityMainGoogleBinding
    lateinit var mProgressDialog: ProgressDialog
    lateinit var apiClient: GoogleApiClient
    private val RC_SIGN_IN = 7

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGoogleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mProgressDialog = ProgressDialog(this)

        var gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        apiClient=GoogleApiClient.Builder(this)
            .enableAutoManage(this,this)
            .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
            .build()

        binding.btnSignIn.setSize(SignInButton.SIZE_STANDARD)
        binding.btnSignIn.setScopes(gso.getScopeArray())

        binding.btnSignIn.setOnClickListener {

            var i: Intent = Auth.GoogleSignInApi.getSignInIntent(apiClient)
            startActivityForResult(i, RC_SIGN_IN)

        }
        binding.btnSignOut.setOnClickListener {

           Auth.GoogleSignInApi.signOut(apiClient).setResultCallback(
               object :ResultCallback<Status>
               {
                   override fun onResult(p0: Status)
                   {
                     UpdateUI(false)
                   }

               }
           )
        }
        binding.btnRevokeAccess.setOnClickListener {

            Auth.GoogleSignInApi.signOut(apiClient).setResultCallback(
                object :ResultCallback<Status>
                {
                    override fun onResult(p0: Status)
                    {
                       UpdateUI(false)
                    }
                })
        }
    }

    fun handleSignInResult(result: GoogleSignInResult?)
    {
        if (result!!.isSuccess) {
            var acct = result.signInAccount
            var personname = acct!!.displayName
            var personphotourl = acct.photoUrl.toString()
            var email = acct.email

            binding.txtName.setText(personname)
            binding.txtEmail.setText(email)
            Glide.with(applicationContext)
                .load(personphotourl)
                .into(binding.imgProfilePic)

            UpdateUI(true)
        }
        else
        {
            UpdateUI(false)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN)
        {
            var result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            handleSignInResult(result)
        }
    }
    private fun UpdateUI(b: Boolean)
    {
        if (b)
        {
            binding.btnSignIn.setVisibility(View.GONE)
            binding.btnSignOut.setVisibility(View.VISIBLE)
            binding.btnRevokeAccess.setVisibility(View.VISIBLE)
            binding.llProfile.setVisibility(View.VISIBLE)
        }
        else
        {
            binding.btnSignIn.setVisibility(View.VISIBLE)
            binding.btnSignOut.setVisibility(View.GONE)
            binding.btnRevokeAccess.setVisibility(View.GONE)
            binding.llProfile.setVisibility(View.GONE)

        }
    }

    override fun onStart()
    {
        super.onStart()
        var opr=Auth.GoogleSignInApi.silentSignIn(apiClient)
        if (opr.isDone)
        {
            Log.d("Tag","Got cached signed in")
            var result=opr.get()
            handleSignInResult(result)
        }
        else
        {
            showProgressDialog()

            opr.setResultCallback {
                object :ResultCallback<GoogleSignInResult>
                {
                    override fun onResult(p0: GoogleSignInResult)
                    {
                        hideprogressDialog()
                        handleSignInResult(p0)
                    }
                }
            }
        }
    }

    override fun onConnectionFailed(p0: ConnectionResult)
    {
       Log.d("Connection Failed", "onConnectionFailed"+p0)
    }

    fun showProgressDialog()
    {
        if (mProgressDialog==null)
        {
            mProgressDialog.setMessage(getString(R.string.loading))
            mProgressDialog.setIndeterminate(true)
        }
        mProgressDialog.show()
    }

    fun hideprogressDialog()
    {
        if (mProgressDialog!=null && mProgressDialog.isShowing)
        {
            mProgressDialog.hide()
        }
    }
}
