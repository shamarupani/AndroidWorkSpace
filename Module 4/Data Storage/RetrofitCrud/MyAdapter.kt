package RetrofitCrud

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonparsinginsertview.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyAdapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<myview>()
{
    lateinit var api:ApiInterface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myview {
            var inflater=LayoutInflater.from(parent.context)
            var view=inflater.inflate(R.layout.design_retro,parent,false)
            return myview(view)
    }

    override fun onBindViewHolder(holder: myview, position: Int) {
       holder.txt1.setText(list[position].product_name)
       holder.txt2.setText(list[position].product_price)

       holder.itemView.setOnClickListener {  v->

           var alert=AlertDialog.Builder(holder.txt1.context)
           alert.setTitle("Select Operations?")
           alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

               var i=Intent(context,UpdateActivity3Retro::class.java)

               var id=list[position].product_id
               var name=list[position].product_name
               var price=list[position].product_price

               i.putExtra("id",id)
               i.putExtra("name",name)
               i.putExtra("price",price)
               i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
               context.startActivity(i)
           })
           alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

               api=ApiClient.getapiclient().create(ApiInterface::class.java)
               var call:Call<Model>?= api.deletedata(list.get(position).product_id)

               call!!.enqueue(object :Callback<Model>{
                   override fun onResponse(call: Call<Model>, response: Response<Model>)
                   {
                       var i=Intent()
                       i.flags=Intent.FLAG_ACTIVITY_NEW_TASK
                   }

                   override fun onFailure(call: Call<Model>, t: Throwable)
                   {

                   }

               })
               v.context.startActivity(Intent(v.context,MainActivity2Retro::class.java))
           })
           alert.show()
       }
    }

    override fun getItemCount(): Int {
         return list.size
    }

}
class myview(var itemView: View):RecyclerView.ViewHolder(itemView)
{
    var txt1:TextView=itemView.findViewById(R.id.txt1)
    var txt2:TextView=itemView.findViewById(R.id.txt2)
}