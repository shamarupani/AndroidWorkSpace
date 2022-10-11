package com.example.milkonmobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<Myview>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {
        var layout:LayoutInflater=LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,parent,false)
        return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, position: Int) {
        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).title)
        holder.price.setText(list.get(position).text)
        holder.subsribe.setText(list.get(position).button)

        holder.add.setText(list.get(position).button1)
    }

    override fun getItemCount(): Int {

        return list.size
    }
}

class Myview(itemView:View):RecyclerView.ViewHolder(itemView)
{
    var text=itemView.findViewById<TextView>(R.id.text)
    var image=itemView.findViewById<ImageView>(R.id.image)
    var price=itemView.findViewById<TextView>(R.id.price)
    var subsribe=itemView.findViewById<Button>(R.id.subscribe)

    var add=itemView.findViewById<Button>(R.id.add)
}
