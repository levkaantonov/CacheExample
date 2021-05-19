package levkaantonov.com.study.cacheexample.api

import levkaantonov.com.study.cacheexample.data.Restaurant
import retrofit2.http.GET

interface RestaurantApi {

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants() : List<Restaurant>


    companion object{
        const val BASE_URL = "https://random-data-api.com/api/"
    }
}