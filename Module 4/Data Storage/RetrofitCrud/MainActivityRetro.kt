package RetrofitCrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsonparsinginsertview.R
import com.example.jsonparsinginsertview.databinding.ActivityInsertBinding
import com.example.jsonparsinginsertview.databinding.ActivityMainRetroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityRetro : AppCompatActivity()
{
    private lateinit var binding: ActivityMainRetroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainRetroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btninsert.setOnClickListener {

            var name=binding.edt1.text.toString()
            var price=binding.edt2.text.toString()

            var data=ApiClient.getapiclient().create(ApiInterface::class.java)
            var call:Call<Void> = data.insertdata(name,price)

            call.enqueue(object :Callback<Void>
            {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(this@MainActivityRetro,"Product Added",Toast.LENGTH_LONG).show()
                    var i=Intent(applicationContext,MainActivity2Retro::class.java)
                    startActivity(i)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                   Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }

            })
        }
    }
}