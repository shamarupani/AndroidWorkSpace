package com.example.egreetings_admin.ApiClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient
{
    companion object
    {
        var BASE_URL="https://shamarayani.000webhostapp.com/egreetings_admin/"
        var retrofit:Retrofit? =null
        fun getapiclient():Retrofit?
        {
            if (retrofit==null)
            {
                retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

            }
            return retrofit
        }
    }
}