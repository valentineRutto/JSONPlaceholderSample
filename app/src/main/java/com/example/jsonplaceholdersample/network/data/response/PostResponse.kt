package com.example.jsonplaceholdersample.network.data.response

data class PostsCollection(
    var postsCollection: List<PostResponse>
)

data class PostResponse(var userId: Int, var id: Int, var title: String, var body: String)