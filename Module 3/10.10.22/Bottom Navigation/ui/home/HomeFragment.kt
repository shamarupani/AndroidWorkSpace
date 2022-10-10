package com.example.bottomnav.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.bottomnav.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    lateinit var txt:TextView
    lateinit var float:FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      var view= inflater.inflate(R.layout.fragment_home, container, false)

        txt=view.findViewById(R.id.text_home)
        float=view.findViewById(R.id.f1)
        float.setOnClickListener {
            Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()
        }
        txt.setOnClickListener {
            Toast.makeText(activity,"Home called",Toast.LENGTH_LONG).show()
        }
        return view
    }

}