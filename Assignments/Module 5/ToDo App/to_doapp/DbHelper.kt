package com.example.to_doapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="task.db"
        var TABLE_NAME="info"
        var ID="id"
        var TITLE="title"
        var DB_VERSION=1
    }

    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query="CREATE TABLE " + TABLE_NAME+ "("+ ID + " INTEGER PRIMARY KEY,"+ TITLE +" TEXT"+ ")"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery="DROP TABLE IF EXISTS "+ TABLE_NAME
        p0!!.execSQL(upquery)
        onCreate(p0)
    }

    fun insertdata(m:Model):Long
    {
        var db=this.writableDatabase
        var contentValues= ContentValues()
        contentValues.put(TITLE,m.title)

        var id=db.insert(TABLE_NAME, ID,contentValues)
        return id
    }
    fun viewdata():List<Model>
    {
        var db=this.readableDatabase
        var list:MutableList<Model> = ArrayList()
        var data= arrayOf(ID, TITLE)
        var cursor: Cursor =db.query(TABLE_NAME,data,null,null,null,null,null)

        while (cursor.moveToNext())
        {
            var id1=cursor.getInt(0)
            var task=cursor.getString(1)

            var m=Model()
            m.id=id1
            m.title=task
            list.add(m)
        }
        return list
    }
    fun updatedata(m: Model)
    {
        var db=this.writableDatabase
        var contentValues=ContentValues()
        contentValues.put(ID,m.id)
        contentValues.put(TITLE,m.title)
        var updatequery= ID +" = "+m.id
        db.update(TABLE_NAME,contentValues,updatequery,null)
    }
    fun deletedata(id:Int)
    {
        var db=this.writableDatabase
        var deletequery= ID+"="+id
        db.delete(TABLE_NAME,deletequery,null)
    }



}