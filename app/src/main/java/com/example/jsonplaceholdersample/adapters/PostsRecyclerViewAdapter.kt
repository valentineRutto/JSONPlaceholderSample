package com.example.jsonplaceholdersample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholdersample.R
import com.example.jsonplaceholdersample.network.data.response.PostResponse
import kotlinx.android.synthetic.main.row_post_item.view.*

class PostsRecyclerViewAdapter :
    RecyclerView.Adapter<PostsRecyclerViewAdapter.ViewHolder>() {

    var postList: List<PostResponse> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_post_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bindData(postList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(postResponse: PostResponse) {
            itemView.txt_title.text = postResponse.title
            itemView.txt_body.text = postResponse.body

        }
    }

    fun addData(postlist: List<PostResponse>) {
        this.postList = postlist
        notifyDataSetChanged()
    }

}