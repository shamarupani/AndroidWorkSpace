package com.example.taskmanagementappnew


data class CardInfo(var title:String, var priority:String, var date: Long, var time: Long)
{

   /* override fun compareTo(other: CardInfo?): Int {
        return if (date == null || other!!.date == null) 0 else date!!.compareTo(other.date)
        if (time == null || other!!.time == null) 0 else time!!.compareTo(other.time)
    }
*/
}