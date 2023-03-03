package com.example.cprogramminghelperapp.Adapter

import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramminghelperapp.Activity.CategoryActivity
import com.example.cprogramminghelperapp.Model.Dashboard_Model
import com.example.cprogramminghelperapp.R

import com.squareup.picasso.Picasso


class DashboardAdapter(var context: Context, var list: MutableList<Dashboard_Model>):RecyclerView.Adapter<myview>()
{
    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myview
    {
        var layout:LayoutInflater = LayoutInflater.from(context)
        var view =layout.inflate(R.layout.design_home,parent,false)

        return myview(view)
    }

    override fun onBindViewHolder(holder: myview, position: Int)
    {

        Picasso.get().load(list.get(position).c_image).into(holder.image)
        holder.text.setText(list.get(position).c_name)


        holder.itemView.setOnClickListener {

            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("d_pos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}

class myview(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var image=itemView.findViewById<ImageView>(R.id.img_home)
    var text=itemView.findViewById<TextView>(R.id.txt_home)
}