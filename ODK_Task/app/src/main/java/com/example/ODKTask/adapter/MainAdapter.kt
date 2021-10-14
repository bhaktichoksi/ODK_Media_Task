package com.example.ODKTask.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ODKTask.R
import com.example.ODKTask.model.ResultsItem
import com.example.ODKTask.view.DetailActivity
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(var context: Activity, private val users: ArrayList<ResultsItem>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: ArrayList<ResultsItem>, position: Int) {
            itemView.apply {
                textViewUserName.text = user[position].name
//                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user[position].thumbnail!!.path + ".jpg")
                    .into(imageViewAvatar)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users,position)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("name", users[position].name)
            intent.putExtra("image", users[position].thumbnail!!.path + "."+users[position].thumbnail!!.extension)
            intent.putExtra("dec", users[position].description)
            intent.putExtra("id", users[position].id)

            context.startActivity(intent)
        }
    }

}