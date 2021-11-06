package levkaantonov.com.study.cacheexample.data

import androidx.room.withTransaction
import kotlinx.coroutines.delay
import levkaantonov.com.study.cacheexample.api.RestaurantApi
import levkaantonov.com.study.cacheexample.util.networkBoundResource
import javax.inject.Inject

class RestaurantsRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantsDb
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}