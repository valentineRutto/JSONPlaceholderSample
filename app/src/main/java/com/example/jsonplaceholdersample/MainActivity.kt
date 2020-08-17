package com.example.jsonplaceholdersample

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholdersample.adapters.PostsRecyclerViewAdapter
import com.example.jsonplaceholdersample.network.Endpoints
import com.example.jsonplaceholdersample.network.RetrofitServiceBuilder
import com.example.jsonplaceholdersample.network.data.response.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PostsRecyclerViewAdapter
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        recyclerView.setHasFixedSize(true)
        adapter = PostsRecyclerViewAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        makePostsCall()
    }

    fun initViews() {
        progressBar = findViewById(R.id.pg_bar)
        recyclerView = findViewById(R.id.rv_posts)
    }

    private fun makePostsCall() {
        var retrofit = RetrofitServiceBuilder.getClient()
        val request = retrofit.create(Endpoints::class.java)
        val call = request.getPosts()

        call.enqueue(object : Callback<List<PostResponse>> {
            override fun onResponse(
                call: Call<List<PostResponse>>,
                response: Response<List<PostResponse>>
            ) {
                if (response.isSuccessful) {
                    var postList = response.body()
                    postList?.let { adapter.addData(it) }
                }

            }

            override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}