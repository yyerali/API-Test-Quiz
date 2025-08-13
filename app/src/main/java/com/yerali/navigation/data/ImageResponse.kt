package com.yerali.navigation.data


import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("download_url")
    val downloadUrl: String
)


