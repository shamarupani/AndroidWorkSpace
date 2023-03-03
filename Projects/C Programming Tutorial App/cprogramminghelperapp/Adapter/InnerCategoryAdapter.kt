package com.example.cprogramminghelperapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cprogramminghelperapp.Model.Inner_Category_Model
import com.example.cprogramminghelperapp.R

class InnerCategoryAdapter(var context: Context, var list: MutableList<Inner_Category_Model>): RecyclerView.Adapter<Myview3>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview3
    {
        var inflater= LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.design_inner_category,parent,false)
        return Myview3(view)
    }

    override fun onBindViewHolder(holder: Myview3, position: Int) {

        holder.text.setText(list.get(position).text)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class Myview3(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var text:TextView=itemView.findViewById(R.id.text_category)
}