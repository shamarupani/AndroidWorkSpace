package com.example.foodfeed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context: Context,var list: MutableList<Model>):BaseAdapter()
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
        var view=layout.inflate(R.layout.design,parent,false)

        var image:ImageView=view.findViewById(R.id.img)
        var fooditem:TextView=view.findViewById(R.id.txt1)
        var resname:TextView=view.findViewById(R.id.txt2)
        var price:TextView=view.findViewById(R.id.txt3)
        var ratings:TextView=view.findViewById(R.id.txt4)

        image.setImageResource(list.get(position).image)
        fooditem.setText(list.get(position).fooditem)
        resname.setText(list.get(position).resname)
        price.setText(list.get(position).price)
        ratings.setText(list.get(position).ratings)

        return view
    }
}