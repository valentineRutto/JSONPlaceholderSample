package com.example.jsonplaceholdersample.network.data.response

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("userId") val userId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)