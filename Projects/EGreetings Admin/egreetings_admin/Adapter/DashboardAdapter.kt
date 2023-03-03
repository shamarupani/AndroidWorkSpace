package com.example.egreetings_admin.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.egreetings_admin.Activity.CategoryActivity
import com.example.egreetings_admin.Model.DashboardModel
import com.example.egreetings_admin.R
import com.squareup.picasso.Picasso

class DashboardAdapter(var context: Context, var list: MutableList<DashboardModel>) : RecyclerView.Adapter<Myview>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {

            var inflater=LayoutInflater.from(context)
            var view=inflater.inflate(R.layout.design_dashboard,parent,false)
            return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, position: Int) {
        holder.txt1.setText(list.get(position).c_name)
        Picasso.get().load(list.get(position).c_image).into(holder.img1)

        holder.itemView.setOnClickListener {
            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("c_pos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

}

class Myview(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var txt1: TextView = itemView.findViewById(R.id.dashboard_txt)
    var img1: ImageView = itemView.findViewById(R.id.dashboard_img)

}
