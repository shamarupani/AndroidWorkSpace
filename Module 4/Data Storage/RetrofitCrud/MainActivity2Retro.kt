package RetrofitCrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.jsonparsinginsertview.R
import com.example.jsonparsinginsertview.databinding.ActivityMainRetro2Binding
import com.example.jsonparsinginsertview.databinding.ActivityMainRetroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2Retro : AppCompatActivity()
{
    private lateinit var binding: ActivityMainRetro2Binding
    lateinit var list: MutableList<Model>
    lateinit var api:ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainRetro2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list=ArrayList()

        var layout:RecyclerView.LayoutManager=LinearLayoutManager(this)
        binding.recycler.layoutManager=layout

         api=ApiClient.getapiclient().create(ApiInterface::class.java)
        var call:Call<List<Model>> = api.viewdata()

        call.enqueue(object: Callback<List<Model>>
        {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                list=response.body() as MutableList<Model>
                var adapter=MyAdapter(applicationContext,list)
                binding.recycler.adapter=adapter
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
              Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }

        })
    }
}