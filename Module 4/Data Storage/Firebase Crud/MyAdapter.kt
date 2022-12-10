package FirebaseCrud

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasecrud.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder

class MyAdapter(options:FirebaseRecyclerOptions<Model>): FirebaseRecyclerAdapter<Model,myviewholder>(options)
{


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
      var view:View=LayoutInflater.from(parent.context).inflate(R.layout.design_firebasecrud,parent,false)
        return myviewholder(view)

    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model) {
        holder.name.setText(model.n1)
        holder.email.setText(model.e1)
        holder.pass.setText(model.p1)


       holder.edit.setOnClickListener {
           var dialogPlus= DialogPlus.newDialog(holder.edit.context)
               .setContentHolder(ViewHolder(R.layout.dialogcontext))
               .setExpanded(true,1100)
               .create()

           var myview=dialogPlus.holderView
           var name=myview.findViewById<EditText>(R.id.uname)
           var pass=myview.findViewById<EditText>(R.id.upass)
           var email=myview.findViewById<EditText>(R.id.uemail)
           var submit=myview.findViewById<Button>(R.id.usubmit)

           name.setText(model.n1)
           pass.setText(model.p1)
           email.setText(model.e1)

           dialogPlus.show()

           submit.setOnClickListener {
               var map:MutableMap<String,Any> = HashMap()
               map["n1"]=name.text.toString()
               map["e1"]=email.text.toString()
               map["p1"]=pass.text.toString()
               FirebaseDatabase.getInstance().reference.child("android123").child(getRef(position).key!!).updateChildren(map)
                   .addOnSuccessListener {
                       Toast.makeText(holder.edit.context,"Updated",Toast.LENGTH_LONG).show()
                   }
                   .addOnFailureListener()
                   {
                       Toast.makeText(holder.edit.context,"Failed",Toast.LENGTH_LONG).show()
                   }
           }
       }


       holder.delete.setOnClickListener {
            var alert= AlertDialog.Builder(holder.delete.context)
            alert.setTitle("Delete?")
            alert.setPositiveButton("Yes",{ dialogInterface: DialogInterface, i: Int ->
                FirebaseDatabase.getInstance().reference
                        .child("android123")
                        .child(getRef(position).getKey()!!)
                       .removeValue()

                notifyItemRangeChanged(position,0)
            })
            alert.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            })
            alert.show()


        }
    }

}


class myviewholder(@NonNull itemView: View):RecyclerView.ViewHolder(itemView)
{

    var name: TextView
    var pass: TextView
    var email: TextView
    var edit: ImageView
    var delete: ImageView

    init
    {

        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        pass = itemView.findViewById(R.id.txt3)
        edit = itemView.findViewById(R.id.edit)
        delete = itemView.findViewById(R.id.delete)

    }


}
