package com.example.submissiondicodingfundamentalandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissiondicodingfundamentalandroid.databinding.ItemListUserBinding
import java.util.ArrayList

class ListUserAdapter(private val listUser: ArrayList<Users>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {


    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class ListViewHolder(private val binding: ItemListUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(users: Users){
            with(binding){
                tvName.text = users.name
                tvUsername.text = users.username
                image.setImageResource(users.avatar)
                cardView.setOnClickListener{
                    onItemClickCallback?.onItemClicked(users)
                }
            }
        }

    }
    interface OnItemClickCallback {
        fun onItemClicked(users: Users)

    }

}


