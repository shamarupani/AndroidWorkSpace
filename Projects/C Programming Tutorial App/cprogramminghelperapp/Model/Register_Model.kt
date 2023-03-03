package com.example.cprogramminghelperapp.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Register_Model
{
    @Expose
    @SerializedName("firstname")
    var fname=""

    @Expose
    @SerializedName("lastname")
    var lname=""

    @Expose
    @SerializedName("username")
    var uname=""

    @Expose
    @SerializedName("email")
    var email=""

    @Expose
    @SerializedName("phone")
    var phone=""

    @Expose
    @SerializedName("city")
    var city=""

    @Expose
    @SerializedName("password")
    var password=""
}