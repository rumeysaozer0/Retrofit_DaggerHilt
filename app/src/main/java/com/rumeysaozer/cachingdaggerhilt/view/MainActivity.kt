package com.rumeysaozer.cachingdaggerhilt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.cachingdaggerhilt.adapter.RestaurantAdapter
import com.rumeysaozer.cachingdaggerhilt.databinding.ActivityMainBinding
import com.rumeysaozer.cachingdaggerhilt.viewmodel.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : RestaurantViewModel by viewModels()
    private val radapter = RestaurantAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.apply {
            recyclerView.apply {
                adapter = radapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            viewModel.restaurants.observe(this@MainActivity){ restaurant ->
                restaurant?.let{
                    radapter.updateRestaurantList(restaurant)
                }

            }
        }
    }
}