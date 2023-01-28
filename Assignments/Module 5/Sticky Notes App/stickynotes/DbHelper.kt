package com.example.stickynotes

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
        companion object
        {
            var DB_NAME="stickynotes"
            var TABLE_NAME="notes"
            var ID="id"
            var NOTE="note"
            var DB_VERSION=1
        }
    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query="CREATE TABLE " + TABLE_NAME+ "("+ ID + " INTEGER PRIMARY KEY,"+ NOTE +" TEXT "+ ")"
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
        contentValues.put(NOTE,m.note)
        var id=db.insert(TABLE_NAME, ID,contentValues)
        return id
    }
    fun viewdata():List<Model>
    {
        var db=this.readableDatabase
        var list:MutableList<Model> = ArrayList()
        var data= arrayOf(ID, NOTE)
        var cursor: Cursor =db.query(TABLE_NAME,data,null,null,null,null,null)

        while (cursor.moveToNext())
        {
            var id1=cursor.getInt(0)
            var note1=cursor.getString(1)


            var m=Model()
            m.id=id1
            m.note=note1
            list.add(m)

        }
        return list
    }
    fun updatedata(m: Model)
    {
        var db=this.writableDatabase
        var contentValues= ContentValues()
        contentValues.put(ID,m.id)
        contentValues.put(NOTE,m.note)

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