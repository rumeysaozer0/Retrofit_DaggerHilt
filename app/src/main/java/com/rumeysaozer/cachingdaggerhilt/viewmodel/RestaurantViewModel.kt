package com.rumeysaozer.cachingdaggerhilt.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumeysaozer.cachingdaggerhilt.model.RestaurantItem
import com.rumeysaozer.cachingdaggerhilt.service.RestaurantApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RestaurantViewModel @Inject constructor(api: RestaurantApi) : ViewModel() {
    private val restaurantData = MutableLiveData<List<RestaurantItem>>()
    val restaurants : LiveData<List<RestaurantItem>> = restaurantData
    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            restaurantData.value = restaurants
        }
    }
}