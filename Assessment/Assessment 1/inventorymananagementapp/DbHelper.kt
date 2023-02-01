package com.example.inventorymananagementapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="inventory.db"
        var DB_VERSION = 1

        var TABLE_NAME = "details"
        var ID = "id"
        var FNAME = "fname"
        var LNAME = "lname"
        var UNAME = "uname"
        var EMAIL = "email"
        var PHONE = "phone"
        var PASSWORD = "pwd"

        var TABLE_NAME2 = "productdetails"
        var ID2="id2"
        var PRODUCT="product"
        var CATEGORY="category"
        var PRICE="price"
        var NUMBER="number"


    }
    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query =
            "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY," + FNAME + " TEXT," + LNAME + " TEXT," + UNAME + " TEXT," + EMAIL + " TEXT," + PHONE + " TEXT," + PASSWORD + " TEXT " + ")"
          var query2=
              "CREATE TABLE " + TABLE_NAME2 + "("+ ID2 + " INTEGER PRIMARY KEY,"+ PRODUCT +" TEXT,"+ CATEGORY +" TEXT,"+  PRICE +" TEXT,"+ NUMBER +" TEXT " + ")"
        p0!!.execSQL(query)
        p0!!.execSQL(query2)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery="DROP TABLE IF EXISTS "+ TABLE_NAME
        var upquery2="DROP TABLE IF EXISTS "+ TABLE_NAME2
        p0!!.execSQL(upquery)
        p0!!.execSQL(upquery2)
        onCreate(p0)
    }

    fun insertdata(m:Model):Long
    {
        var db=this.writableDatabase
        var contentvalues=ContentValues()
        contentvalues.put(FNAME, m.fname)
        contentvalues.put(LNAME, m.lname)
        contentvalues.put(UNAME, m.uname)
        contentvalues.put(EMAIL, m.email)
        contentvalues.put(PHONE, m.phone)
        contentvalues.put(PASSWORD, m.pwd)
        var id=db.insert(TABLE_NAME, ID,contentvalues)
        return id
    }
    fun insertproduct(m:Model_product):Long
    {
        var db=this.writableDatabase
        var contentValues=ContentValues()
        contentValues.put(PRODUCT,m.product)
        contentValues.put(PRICE,m.price)
        contentValues.put(CATEGORY,m.category)
        contentValues.put(NUMBER,m.number)
        var id=db.insert(TABLE_NAME2, ID2,contentValues)
        return id
    }
    fun viewproduct():List<Model_product>
    {
        var db=this.readableDatabase
        var list:MutableList<Model_product> = ArrayList()
        var data= arrayOf(ID2, PRODUCT, PRICE, CATEGORY, NUMBER)
        var cursor:Cursor=db.query(TABLE_NAME2,data,null,null,null,null,null)

        while (cursor.moveToNext())
        {
            var id1=cursor.getInt(0)
            var product1=cursor.getString(1)
            var price1=cursor.getString(2)
            var category1=cursor.getString(3)
            var number1=cursor.getString(4)

            var m=Model_product()
            m.id2=id1
            m.product=product1
            m.price=price1
            m.category=category1
            m.number=number1
            list.add(m)

        }
        return list
    }
    fun deleteproduct(id:Int)
    {
        var db=this.writableDatabase
        var deletequery= ID2+"="+id
        db.delete(TABLE_NAME2,deletequery,null)
    }

}