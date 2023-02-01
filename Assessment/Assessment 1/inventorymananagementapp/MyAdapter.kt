package com.example.inventorymananagementapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var list: MutableList<Model1>): RecyclerView.Adapter<myview>()
{
    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myview
    {
        var layout: LayoutInflater = LayoutInflater.from(context)
        var view =layout.inflate(R.layout.design,parent,false)

        return myview(view)

    }

    override fun onBindViewHolder(holder: myview, position: Int)
    {
        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).text)
        holder.itemView.setOnClickListener {
            var i=Intent(context,MainActivity2::class.java)
            i.putExtra("c_pos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
      /* if (position==0)
       {
           Toast.makeText(holder.itemView.context,"add",Toast.LENGTH_LONG).show()
           var i=Intent(holder.itemView.context,CategoryActivity::class.java)
           holder.itemView.context.startActivity(i)
       }
        if (position==1)
        {
            var i=Intent(holder.itemView.context,ProductViewActivity::class.java)
            holder.itemView.context.startActivity(i)
        }
        if (position==2)
        {
            var i=Intent(holder.itemView.context,ProducyDeleteActivity::class.java)
            holder.itemView.context.startActivity(i)
        }
        if (position==3)
        {
            var i=Intent(holder.itemView.context,QrcodeScannActivity::class.java)
            holder.itemView.context.startActivity(i)
        }*/
    }


}

class myview(itemView: View): RecyclerView.ViewHolder(itemView)
{
    var image=itemView.findViewById<ImageView>(R.id.img)
    var text=itemView.findViewById<TextView>(R.id.txt)
}