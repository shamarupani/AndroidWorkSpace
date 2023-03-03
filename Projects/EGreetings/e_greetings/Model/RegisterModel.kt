package com.example.e_greetings.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterModel
{
    @Expose
    @SerializedName("firstname")
    var fname=""

    @Expose
    @SerializedName("lastname")
    var lname=""

    @Expose
    @SerializedName("email")
    var email=""

    @Expose
    @SerializedName("mobileno")
    var mobile=""

    @Expose
    @SerializedName("city")
    var city=""

    @Expose
    @SerializedName("password")
    var password=""
}