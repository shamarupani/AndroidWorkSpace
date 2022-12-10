package OtpVerification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.jsonparsinginsertview.R
import com.example.jsonparsinginsertview.databinding.ActivityMainActivityotpBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivityotp : AppCompatActivity()
{
    private lateinit var binding: ActivityMainActivityotpBinding
    lateinit var auth:FirebaseAuth
    lateinit var verificationid:String

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivityotpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth=FirebaseAuth.getInstance()

        binding.idBtnGetOtp.setOnClickListener {

            if (TextUtils.isEmpty(binding.idEdtPhoneNumber.text.toString()))
            {
                Toast.makeText(this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val phone:String=binding.idEdtPhoneNumber.text.toString()
                sendVerificationcode(phone)
            }
        }
        binding.idBtnVerify.setOnClickListener {
            if (TextUtils.isEmpty(binding.idEdtPhoneNumber.text.toString()))
            {

                Toast.makeText(this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            }
            else
            {

                val otp: String = binding.idEdtOtp.text.toString()
                verifycode(otp)
            }

        }
    }

    private fun verifycode(otp: String)
    {

        val credential=PhoneAuthProvider.getCredential(verificationid,otp)
        signinwithcredential(credential)
    }

    private fun signinwithcredential(credential: PhoneAuthCredential)
    {
        auth.signInWithCredential(credential)
            .addOnCompleteListener()
            {
                if (it.isSuccessful)
                {
                    var i = Intent(this,MainActivityotp2::class.java)
                    startActivity(i)
                }
                else
                {

                }

            }
            .addOnFailureListener()
            {

            }
    }
    var mCallBack:PhoneAuthProvider.OnVerificationStateChangedCallbacks =object :PhoneAuthProvider.OnVerificationStateChangedCallbacks()
    {
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            var code=p0.smsCode
            if (code!=null)
            {
                binding.idEdtOtp.setText(code)
            }
            else
            {
                Toast.makeText(applicationContext,"Error  ", Toast.LENGTH_LONG).show();
            }
        }

        override fun onVerificationFailed(p0: FirebaseException) {

        }

        override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken)
        {

         verificationid=p0
        }

    }


    private fun sendVerificationcode(phone: String)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone,60,TimeUnit.SECONDS,this,mCallBack)
    }
}