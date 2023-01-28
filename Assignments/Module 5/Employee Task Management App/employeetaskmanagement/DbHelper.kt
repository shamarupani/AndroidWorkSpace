package com.example.employeetaskmanagement

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.FileInputStream

class DbHelper(var context: Context):SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    companion object {
        var DB_NAME = "employee.db"
        var TABLE_NAME = "details"
        var ID = "id"
        var FNAME = "fname"
        var LNAME = "lname"
        var UNAME = "uname"
        var EMAIL = "email"
        var PHONE = "phone"
        var PASSWORD = "pwd"

        var TABLE_NAME2 = "project"
        var ID2 = "id2"
        var TITLE = "title"
        var DESCRIPTION = "desc"

        var DB_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var query =
            "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY," + FNAME + " TEXT," + LNAME + " TEXT," + UNAME + " TEXT," + EMAIL + " TEXT," + PHONE + " TEXT," + PASSWORD + " TEXT " + ")"
        var query2 =
            "CREATE TABLE " + TABLE_NAME2 + "(" + ID2 + " INTEGER PRIMARY KEY," + TITLE + " TEXT," + DESCRIPTION + " TEXT" + ")"

        p0!!.execSQL("CREATE TABLE IF NOT EXISTS user ( id INTEGER PRIMARY KEY AUTOINCREMENT, pp BLOB)")
        p0!!.execSQL(query)
        p0.execSQL(query2)
     }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery = "DROP TABLE IF EXISTS " + TABLE_NAME
        var upquery2 = "DROP TABLE IF EXISTS " + TABLE_NAME2

         p0!!.execSQL("DROP TABLE IF EXISTS user")
         p0!!.execSQL(upquery)
         p0!!.execSQL(upquery2)
        onCreate(p0)
    }

    fun insertdata(m: Model): Long {
        var db = this.writableDatabase
        var contentvalues = ContentValues()
        contentvalues.put(FNAME, m.fname)
        contentvalues.put(LNAME, m.lname)
        contentvalues.put(UNAME, m.uname)
        contentvalues.put(EMAIL, m.email)
        contentvalues.put(PHONE, m.phone)
        contentvalues.put(PASSWORD, m.pwd)
        var id = db.insert(TABLE_NAME, ID, contentvalues)
        return id
    }

    fun viewdata(): List<Model> {
        var db = this.readableDatabase
        var list: MutableList<Model> = ArrayList()
        var data = arrayOf(ID, FNAME, LNAME, UNAME, EMAIL, PHONE, PASSWORD)
        var cursor: Cursor = db.query(TABLE_NAME, data, null, null, null, null, null)
        while (cursor.moveToNext()) {
            var id1 = cursor.getInt(0)
            var fname1 = cursor.getString(1)
            var lname1 = cursor.getString(2)
            var uname1 = cursor.getString(3)
            var email1 = cursor.getString(4)
            var phone1 = cursor.getString(5)
            var password1 = cursor.getString(6)

            var m = Model()
            m.id = id1
            m.fname = fname1
            m.lname = lname1
            m.uname = uname1
            m.email = email1
            m.phone = phone1
            m.pwd = password1

            list.add(m)
        }
        return list
    }

    fun insertproject(m1: Model_project): Long {
        var db = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(TITLE, m1.title)
        contentValues.put(DESCRIPTION, m1.desc)
        var id = db.insert(TABLE_NAME2, ID2, contentValues)
        return id
    }

    fun viewproject(): List<Model_project> {
        var db = this.readableDatabase
        var list: MutableList<Model_project> = ArrayList()
        var data = arrayOf(ID2, TITLE, DESCRIPTION)
        var cursor: Cursor = db.query(TABLE_NAME2, data, null, null, null, null, null)

        while (cursor.moveToNext()) {
            var id1 = cursor.getInt(0)
            var title1 = cursor.getString(1)
            var desc1 = cursor.getString(2)

            var m1 = Model_project()
            m1.id = id1
            m1.title = title1
            m1.desc = desc1

            list.add(m1)
        }
        return list
    }

    fun deleteproject(id: Int)
    {
        var db = this.writableDatabase
        var deletequery = ID2 + "=" + id
        db.delete(TABLE_NAME2, deletequery, null)
    }

    fun updateproject(m: Model_project)
    {
        var db = this.writableDatabase
        var contentValues = ContentValues()
        contentValues.put(ID2, m.id)
        contentValues.put(TITLE, m.title)
        contentValues.put(DESCRIPTION, m.desc)
        var updatequery = ID2 + " = " + m.id
        db.update(TABLE_NAME2, contentValues, updatequery, null)
    }

    fun save(id: Int, pp: ByteArray?): Boolean
    {
        return try {
            val cv = ContentValues()
            cv.put("id", id)
            cv.put("pp", pp)
            val db = this.writableDatabase
            db.insert("user", null, cv)
            true
        }
        catch (e: Exception)
        {
            e.printStackTrace()
            false
        }
    }
    fun update(id: Int, pp: ByteArray?): Boolean
    {
        return try {
            val cv = ContentValues()
            cv.put("pp", pp)
            val db = this.writableDatabase
            db.update("user", cv, "id=?", arrayOf(id.toString()))
            db.close()
            true
        }
        catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    fun getUser(query: String?): User?
    {
        return try {
            var user: User? = null
            val db = this.readableDatabase
            val cursor = db.rawQuery(query, null)
            if (cursor.moveToFirst())
            {
                val id = cursor.getInt(0)
                val pp = cursor.getBlob(1)
                user = User(id, pp)
            }
            user
        } catch (e: Exception)
        {
            e.printStackTrace()
            null
        }
    }
}
