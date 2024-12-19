package com.example.kotlin_pr56.retrofit

import com.example.kotlin_pr56.retrofit.Model
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("recipes/{id}")

    suspend fun getReсeptsById(@Path("id") id:Int): Model
}