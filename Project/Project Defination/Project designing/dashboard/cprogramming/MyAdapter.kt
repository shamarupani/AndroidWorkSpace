package com.example.cprogramming

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<myview>()
{
    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myview
    {
        var layout:LayoutInflater = LayoutInflater.from(context)
        var view =layout.inflate(R.layout.design,parent,false)

        return myview(view)

    }

    override fun onBindViewHolder(holder: myview, position: Int)
    {

        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).text)
    }


}

class myview(itemView: View):RecyclerView.ViewHolder(itemView)
{
    var image=itemView.findViewById<ImageView>(R.id.img)
    var text=itemView.findViewById<TextView>(R.id.txt)
}
