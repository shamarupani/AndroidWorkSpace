package com.example.egreetings_admin.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterModel
{
    @Expose
    @SerializedName("fname")
    var fname=""

    @Expose
    @SerializedName("lname")
    var lname=""

    @Expose
    @SerializedName("mobileno")
    var mobile=""

    @Expose
    @SerializedName("email")
    var email=""

    @Expose
    @SerializedName("password")
    var password=""
}