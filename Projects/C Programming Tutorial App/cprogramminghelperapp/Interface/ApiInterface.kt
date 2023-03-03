package com.example.cprogramminghelperapp.Interface

import com.example.cprogramminghelperapp.Model.Category_Model
import com.example.cprogramminghelperapp.Model.Dashboard_Model
import com.example.cprogramminghelperapp.Model.Inner_Category_Model
import com.example.cprogramminghelperapp.Model.Register_Model
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
        @Field("firstname") firstname:String,
        @Field("lastname") lastname:String,
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("phone") phone:String,
        @Field("city") city:String,
        @Field("password") password:String
    ):Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindetail(
        @Field("username") username:String,
        @Field("password") password: String

    ):Call<Register_Model>

    @get:GET("dashboard.php")
    var dashboarddetail:Call<List<Dashboard_Model>>

    @get:GET("tutorial.php")
    var tutorialview:Call<List<Category_Model?>?>?

    @get:GET("program.php")
    var programview:Call<List<Category_Model?>?>?

    @get:GET("clanguage.php")
    var clanguagequestionsview:Call<List<Category_Model?>?>?


    @get:GET("pattern.php")
    var patternview:Call<List<Category_Model?>?>?


    @get:GET("introduction.php")
    var introductionview:Call<List<Inner_Category_Model?>?>?

    @get:GET("facts.php")
    var factsview:Call<List<Inner_Category_Model?>?>?

    @get:GET("basic.php")
    var basicview:Call<List<Inner_Category_Model?>?>?

    @get:GET("advanced.php")
    var advancedview:Call<List<Inner_Category_Model?>?>?

    @get:GET("interview.php")
    var interviewview:Call<List<Inner_Category_Model?>?>?

    @get:GET("patternview.php")
    var innerpatternview:Call<List<Inner_Category_Model?>?>?
}