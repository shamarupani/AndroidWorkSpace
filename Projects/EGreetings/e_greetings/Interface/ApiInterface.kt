package com.example.e_greetings.Interface

import com.example.e_greetings.Model.Category_Model
import com.example.e_greetings.Model.Dashboard_Model
import com.example.e_greetings.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface
{

    @FormUrlEncoded
    @POST("register.php")
    fun registerdetail(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname :String?,
        @Field("email") email:String?,
        @Field("mobileno") mobile:String?,
        @Field("city") city:String?,
        @Field("password") password:String?
    ):Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("mobileno") mobile :String?,
        @Field("password") password :String?
    ):Call<RegisterModel>

    @get:GET("dashboard.php")
    var dashboardview:Call<List<Dashboard_Model?>?>?

    @get:GET("diwali.php")
    var diwaliview:Call<List<Category_Model?>?>?

    @get:GET("holi.php")
    var holiview:Call<List<Category_Model?>?>?

    @get:GET("birthday.php")
    var birthdayview:Call<List<Category_Model?>?>?

    @get:GET("anniversary.php")
    var anniversaryview:Call<List<Category_Model?>?>?

    @get:GET("eid.php")
    var eidview:Call<List<Category_Model?>?>?
}