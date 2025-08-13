package com.yerali.navigation.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL="https://picsum.photos"

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    val apiService:ApiService = retrofit.create(ApiService::class.java)
}