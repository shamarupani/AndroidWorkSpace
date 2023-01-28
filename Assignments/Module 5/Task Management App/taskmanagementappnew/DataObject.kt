package com.example.taskmanagementappnew


object DataObject
{
    var listdata= mutableListOf<EntityClass>()

    fun setdata(title:String, priority:String,date:Long,time: Long)
    {
        listdata.add(EntityClass(title,priority,date,time))
    }
    fun getalldata():List<EntityClass>
    {
        return listdata
    }
    fun deleteAll()
    {
        listdata.clear()
    }

    fun getdata(pos:Int): EntityClass
    {
        return listdata[pos]
    }
    fun deletedata(pos:Int)
    {
        listdata.removeAt(pos)
    }
    fun updatedata(pos:Int, title: String, priority: String, date: Long, time: Long)
    {
        listdata[pos].title=title
        listdata[pos].priority=priority
        listdata[pos].date=date
        listdata[pos].time=time
    }
  /*fun sorttask(date: String)
    {
        Collections.sort(listdata, object : Comparator<CardInfo>
        {
            override fun compare(o1: CardInfo, o2: CardInfo): Int
            {
                return o1!!.date!!.compareTo(o2!!.date)

            }
        })
    }*//*
    fun sorttime(time: String)
    {
        Collections.sort(listdata, object : Comparator<CardInfo>
        {
            override fun compare(o1: CardInfo, o2: CardInfo): Int
            {
                return o1!!.time!!.compareTo(o2!!.time)

            }
        })
    }*/

}