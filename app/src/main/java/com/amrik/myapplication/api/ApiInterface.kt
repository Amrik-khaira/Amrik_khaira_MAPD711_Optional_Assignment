package com.amrik.myapplication.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("fragrances")
    fun getCategories(): Call<ResponseBody>



}