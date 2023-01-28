package com.example.taskmanagementappnew

import android.content.Intent
import android.graphics.Color
import android.provider.Settings.Global
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class Adapter(var data: List<EntityClass>):RecyclerView.Adapter<viewholder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder
    {

        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return viewholder(itemView)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int)
    {
        holder.bind(data[position])
        when(data[position].priority.toLowerCase())
        {
            "high"-> holder.layout.setBackgroundColor(Color.RED)
            "medium" -> holder.layout.setBackgroundColor(Color.BLUE)
            else -> holder.layout.setBackgroundColor(Color.GREEN)
        }


      //  holder.title.setText(data[position].title)
      //  holder.priority.setText(data[position].priority)
       /* holder.itemView.setOnClickListener {
            var i=Intent(holder.itemView.context,UpdateCard::class.java)
            i.putExtra("id",position)
            holder.itemView.context.startActivity(i)
        }*/
    }

    override fun getItemCount(): Int
    {
       return data.size
    }


}

class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var layout=itemView.findViewById<LinearLayout>(R.id.mylayout)

    fun bind(EntityClass: EntityClass) {
            with(itemView)
            {
                itemView.findViewById<TextView>(R.id.title).text = EntityClass.title
                itemView.findViewById<TextView>(R.id.priority).text = EntityClass.priority


                updateTime(EntityClass.time)
                updateDate(EntityClass.date)
            }
    }

    private fun updateDate(time: Long) {
              var myformat="EEE, d MMM yyyy"
              var sdf=SimpleDateFormat(myformat)
              itemView.findViewById<TextView>(R.id.date).text = sdf.format(Date(time))

    }

    private fun updateTime(time: Long) {
            var myformat="h:mm a"
            var sdf=SimpleDateFormat(myformat)
            itemView.findViewById<TextView>(R.id.time).text=sdf.format(Date(time))
    }

  /*  var title=itemView.findViewById<TextView>(R.id.title)
            var priority=itemView.findViewById<TextView>(R.id.priority)
            var layout=itemView.findViewById<LinearLayout>(R.id.mylayout)
            var date=itemView.findViewById<TextView>(R.id.date)
            var time=itemView.findViewById<TextView>(R.id.time)
*/

}
