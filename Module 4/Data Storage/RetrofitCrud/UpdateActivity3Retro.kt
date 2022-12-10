package RetrofitCrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jsonparsinginsertview.R
import com.example.jsonparsinginsertview.databinding.ActivityMainRetroBinding
import com.example.jsonparsinginsertview.databinding.ActivityUpdateRetro3Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity3Retro : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateRetro3Binding
    lateinit var api:ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding =ActivityUpdateRetro3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent
        var id=i.getIntExtra("id",101)
        binding.edt1.setText(i.getStringExtra("name"))
        binding.edt2.setText(i.getStringExtra("price"))

        binding.btnupdate.setOnClickListener {
            var name=binding.edt1.text.toString()
            var price=binding.edt2.text.toString()

            api=ApiClient.getapiclient().create(ApiInterface::class.java)
            var call:Call<Void> = api.updatedata(id,name,price)

            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext,"Product Updated",Toast.LENGTH_LONG).show()
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