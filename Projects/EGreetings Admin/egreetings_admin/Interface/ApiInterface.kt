package com.example.egreetings_admin.Interface

import com.example.egreetings_admin.Model.DashboardModel
import com.example.egreetings_admin.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface
{

        @FormUrlEncoded
        @POST("login_admin.php")
        fun logindata(
                @Field("mobileno") mobile:String?,
                @Field("password") password:String?
        ):Call<RegisterModel>

        @get:GET("dashboard_admin.php")
        val dashboarview:Call<List<DashboardModel?>?>?

        @get:GET("diwaliupload.php")
        var diwaliupload:Call<List<DashboardModel?>?>?
}