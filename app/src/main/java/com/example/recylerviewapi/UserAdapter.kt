package com.example.recylerviewapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val listUser: ArrayList<MainModel.Result>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.findViewById(R.id.textView)
        val imgView : ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = listUser[position]
        holder.tvItem.text = result.login
        Glide.with(holder.itemView)
            .load(result.avatar_url)
            .error(R.mipmap.ic_launcher_round)
            .circleCrop()
            .into(holder.imgView)
    }

    override fun getItemCount() = listUser.size

    fun setData(data: ArrayList<MainModel.Result>){
        this.listUser.clear()
        this.listUser.addAll(data)
        notifyDataSetChanged()
    }
}