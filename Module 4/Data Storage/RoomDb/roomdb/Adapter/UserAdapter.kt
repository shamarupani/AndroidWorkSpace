
package com.example.roomdb

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
import androidx.room.Room
import com.example.roomdb.Activity.AddUserActivity
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Entity.User
import com.example.roomdb.GlobalVariables.GlobalVariables

class UserAdapter(userList : MutableList<User>) : RecyclerView.Adapter<UserHolder?>()
{
    var userList:MutableList<User>
    var db:DatabaseClass?=null
   private var mContext:Context?=null

    init {
        this.userList=userList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder
    {
        mContext=parent.context
        db=Room.databaseBuilder(parent.context,DatabaseClass::class.java,"myDatabase").allowMainThreadQueries().build()
        var v:View=LayoutInflater.from(parent.context).inflate(R.layout.user_adapter,parent,false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int)
    {
      holder.name.setText(userList[position].name.toString())
      holder.email.setText(userList[position].email.toString())
      holder.itemView.setOnClickListener {

          var alertDialog=AlertDialog.Builder(mContext).create()
          alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Edit"){ dialogInterface: DialogInterface, i: Int ->
              GlobalVariables.id=userList[position].id
              GlobalVariables.name=userList[position].name
              GlobalVariables.email=userList[position].email
              GlobalVariables.updateFlag="update"
              var intent=Intent(mContext,AddUserActivity::class.java)
              mContext!!.startActivity(intent)
          }
          alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"Delete"){ dialogInterface: DialogInterface, i: Int ->
              deleteUser(userList[position].id)
              dialogInterface.dismiss()
              userList.removeAt(position)
              notifyItemRemoved(position)
              notifyItemRangeChanged(position,userList.size)
          }
          alertDialog.show()
      }

    }
    fun deleteUser(id:Int)
    {
        var user=User()
        user.id=id
        db!!.daoClass().deleteUser(user)
        Toast.makeText(mContext,"Deleted",Toast.LENGTH_LONG).show()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
        val name:TextView
        var email:TextView
        init {
            name=itemView.findViewById<TextView>(R.id.name)
            email=itemView.findViewById<TextView>(R.id.email)
        }
}