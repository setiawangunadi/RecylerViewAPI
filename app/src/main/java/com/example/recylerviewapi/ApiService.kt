package com.example.recylerviewapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser() : Call<MainModel>
}