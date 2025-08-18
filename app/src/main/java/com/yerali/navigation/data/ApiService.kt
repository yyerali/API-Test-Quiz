package com.yerali.navigation.data
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers(
        "User-Agent: PostmanRuntime/7.45.0",
        "Accept: */*"
    )
    @GET("/v2/list")
    suspend fun getImages(): List<ImageResponse>
}