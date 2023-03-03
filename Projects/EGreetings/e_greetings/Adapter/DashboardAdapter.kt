package com.example.e_greetings.Adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetings.Activity.CategoryActivity
import com.example.e_greetings.Model.Dashboard_Model
import com.example.e_greetings.R
import com.squareup.picasso.Picasso

class DashboardAdapter(var context: Context,var list: MutableList<Dashboard_Model>):RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
       var inflater = LayoutInflater.from(context)
       var view = inflater.inflate(R.layout.design_dashboard,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.txt1.setText(list.get(position).c_name)
        Picasso.get().load(list.get(position).c_image).into(holder.img1)

        holder.itemView.setOnClickListener {
            var i=Intent(context,CategoryActivity::class.java)
            i.putExtra("c_pos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int
    {
       return list.size
    }
}

    class MyView(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var txt1:TextView=itemView.findViewById(R.id.text_dashboard)
        var img1:ImageView=itemView.findViewById(R.id.image_dashboard)
    }
