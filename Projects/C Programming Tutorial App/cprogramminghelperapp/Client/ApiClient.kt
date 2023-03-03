package com.example.cprogramminghelperapp.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        var BASE_URL="https://shamarayani.000webhostapp.com/cprogramming/"
        var retrofit: Retrofit?=null
        fun getapiclient(): Retrofit?
        {
            if (retrofit==null)
            {
                retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }
    }
}