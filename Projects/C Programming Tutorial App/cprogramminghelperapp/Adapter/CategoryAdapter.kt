package com.example.cprogramminghelperapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramminghelperapp.Activity.Fullscreenactivity
import com.example.cprogramminghelperapp.Model.Category_Model
import com.example.cprogramminghelperapp.R
import com.squareup.picasso.Picasso

class CategoryAdapter(var context: Context, var list: MutableList<Category_Model>,var pos:Int): RecyclerView.Adapter<Myview2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview2
    {
        var inflater= LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.design_category,parent,false)
        return Myview2(view)
    }

    override fun onBindViewHolder(holder: Myview2, position: Int) {
        Picasso.get().load(list.get(position).image).into(holder.img)

        holder.itemView.setOnClickListener {

            var i = Intent(context, Fullscreenactivity::class.java)

            i.putExtra("c_pos",position)
            i.putExtra("d_pos",pos)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}

class Myview2(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var img:ImageView=itemView.findViewById(R.id.image_category)
}