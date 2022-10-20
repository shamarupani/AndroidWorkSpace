package com.example.realmdatabase

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmApp:Application()
{

    override fun onCreate()
    {
        super.onCreate()
        Realm.init(this)
        var configuration=RealmConfiguration.Builder()
            .name("user.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(configuration)

    }

}