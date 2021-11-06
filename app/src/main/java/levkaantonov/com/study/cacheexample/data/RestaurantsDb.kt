package levkaantonov.com.study.cacheexample.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Restaurant::class], version = 1)
abstract class RestaurantsDb : RoomDatabase() {
    abstract fun restaurantDao() : RestaurantDao
}