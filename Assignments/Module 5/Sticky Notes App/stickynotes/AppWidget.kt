package com.example.stickynotes

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView

class AppWidget :AppWidgetProvider()
{
    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?)
    {
        for (appWidgetId in appWidgetIds!!)
        {
           var launchintent=Intent(context,MainActivity::class.java)
            // Attaching a Pending Intent to trigger it when application is not alive
            var pendingintent=PendingIntent.getActivity(context,0,launchintent,0)
            //remote views is used to inflate layout file which we have created
            var remoteviews=RemoteViews(context!!.packageName,R.layout.widget_layout)
            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            remoteviews.setOnClickPendingIntent(R.id.textwidget,pendingintent)
            appWidgetManager!!.updateAppWidget(appWidgetId,remoteviews)
        }

    }
}