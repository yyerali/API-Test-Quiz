package com.yerali.navigation.data
import retrofit2.http.GET
interface ApiService {
    @GET("/v2/list")
    suspend fun getImages(): List<ImageResponse>
}