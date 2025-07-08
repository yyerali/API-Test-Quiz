package com.yerali.navigation.data
import retrofit2.http.GET
interface ApiService {
    @GET("/api.php?amount=1&category=15")
    suspend fun getFact():FactBackResponse
}