package com.rumeysaozer.cachingdaggerhilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rumeysaozer.cachingdaggerhilt.databinding.ItemRowBinding
import com.rumeysaozer.cachingdaggerhilt.model.RestaurantItem


class RestaurantAdapter(val restaurantList : ArrayList<RestaurantItem> ):RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>(){
    class RestaurantHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RestaurantHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
       holder.binding.name.text = restaurantList[position].name
        holder.binding.type.text = restaurantList[position].type
        Glide.with(holder.itemView).load(restaurantList[position].logo).into(holder.binding.imageLogo)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }
    fun updateRestaurantList(newRestaurantList: List<RestaurantItem>){
        restaurantList.clear()
        restaurantList.addAll(newRestaurantList)
        notifyDataSetChanged()
    }

}