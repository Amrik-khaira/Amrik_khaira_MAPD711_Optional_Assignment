package com.amrik.myapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    val baseUrl = "https://dummyjson.com/products/category/"
    private fun getRetrofitClient(): Retrofit {
        val client =
            OkHttpClient.Builder().connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build()
        return Retrofit.Builder().baseUrl(baseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getCategoryListApi(): ApiInterface {
        return getRetrofitClient().create(ApiInterface::class.java)
    }


}