package com.example.milkonmobile.ui.Home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.milkonmobile.Model
import com.example.milkonmobile.MyAdapter
import com.example.milkonmobile.R
import java.util.ArrayList

class HomeFragment : Fragment() {

    lateinit var toolbar: Toolbar
    lateinit var slider: SliderLayout
    lateinit var recycler: RecyclerView
    lateinit var list: MutableList<Model>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
       var view=  inflater.inflate(R.layout.fragment_home, container, false)
        toolbar=view.findViewById(R.id.toolbar)

        toolbar.setTitle("Home")


        slider=view.findViewById(R.id.slider)

        var map=HashMap<String,Int>()
        map.put("A", R.drawable.a)
        map.put("B",R.drawable.b)
        map.put("C",R.drawable.c)
        map.put("D",R.drawable.d)
        map.put("E",R.drawable.e)
        map.put("F",R.drawable.f)
        map.put("G",R.drawable.g)
        map.put("H",R.drawable.h)


        for (name in map.keys)
        {
            var textslider= TextSliderView(activity)
            textslider.image(map.get(name)!!)
            slider.addSlider(textslider)
        }

        recycler=view.findViewById(R.id.recycler)
        list= ArrayList()


        var layout:RecyclerView.LayoutManager= GridLayoutManager(activity,2)
        recycler.layoutManager=layout


        list.add(Model("SUPER GOLD 500 ml",R.drawable.milk,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.ghee,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.milk,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))
        list.add(Model("SUPER GOLD 500 ml",R.drawable.ghee,"Rs. 33.0","Subscribe @ ₹33.0","-","0","+","ADD"))

        var adapter= MyAdapter(requireActivity(),list)
        recycler.adapter=adapter
    return view
    }




    }


