package FirebaseCrud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrud.databinding.ActivityMain2FirebaseBinding
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity2Firebase : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2FirebaseBinding
    lateinit var adapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2FirebaseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var layout:RecyclerView.LayoutManager=LinearLayoutManager(this)
        binding.recycler.layoutManager=layout

        val options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("android123"), Model::class.java)
            .build()

        adapter=MyAdapter(options)
        binding.recycler.adapter=adapter

        }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        adapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        adapter.stopListening()
    }

}