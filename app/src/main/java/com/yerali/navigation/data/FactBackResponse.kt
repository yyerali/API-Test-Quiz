package com.yerali.navigation.data

import com.google.gson.annotations.SerializedName
data class FactBackResponse(
    @SerializedName("response_code")
    val response_code: Int,
    @SerializedName("results")
    val results: List<Any>
)