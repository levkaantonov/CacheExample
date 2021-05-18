package levkaantonov.com.study.cacheexample.features.restaurans

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import levkaantonov.com.study.cacheexample.data.Restaurant
import levkaantonov.com.study.cacheexample.databinding.RestaurantItemBinding

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(RestaurantDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem != null){
            holder.bind(currentItem)
        }

    }

    class RestaurantViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(ivLogo)

                tvName.text = restaurant.name
                tvType.text = restaurant.type
                tvAddress.text = restaurant.address
            }
        }
    }
}

class RestaurantDiffUtil : DiffUtil.ItemCallback<Restaurant>(){
    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
        oldItem.name == newItem.name

    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
        oldItem == newItem
}