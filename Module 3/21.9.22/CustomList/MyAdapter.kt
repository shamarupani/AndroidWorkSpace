package com.example.customlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context:Context,var list: MutableList<Model>):BaseAdapter()    //here myadapter is constructor and its object is created in mainactivity.kt
{
    override fun getCount(): Int
    {
        return list.size

    }

    override fun getItem(position: Int): Any
    {
        return position
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var layout=LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,parent,false    )

                 var image:ImageView=view.findViewById(R.id.img)
                 var name:TextView=view.findViewById(R.id.txtname)
                 var des:TextView=view.findViewById(R.id.txtdes)

                name.setText(list.get(position).name)
                des.setText(list.get(position).des)
                image.setImageResource(list.get(position).image)
        return view
    }
}