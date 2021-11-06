package levkaantonov.com.study.cacheexample.features.restaurans

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import levkaantonov.com.study.cacheexample.api.RestaurantApi
import levkaantonov.com.study.cacheexample.data.Restaurant
import levkaantonov.com.study.cacheexample.data.RestaurantsRepository
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantsRepository
) : ViewModel() {
    val restaurants = repository.getRestaurants().asLiveData()

//    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData
//
//    init {
//        viewModelScope.launch {
//            val restaurants = api.getRestaurants()
//            delay(2000)
//            restaurantsLiveData.value = restaurants
//        }
//    }
}