package com.example.jsonplaceholdersample.network

import com.example.jsonplaceholdersample.network.data.response.PostResponse
import com.example.jsonplaceholdersample.network.data.response.PostsCollection
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET("/posts")
    fun getPosts(): Call<List<PostResponse>>
}