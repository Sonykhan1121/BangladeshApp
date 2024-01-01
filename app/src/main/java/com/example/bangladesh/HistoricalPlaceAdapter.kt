package com.example.bangladesh


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangladesh.databinding.ItemHistoricalPlaceBinding

class HistoricalPlaceAdapter( val historicalplaces:List<HistoricalPlaceItem>,private val clickListener: OnItemClickListener):RecyclerView.Adapter<HistoricalPlaceAdapter.HistoricalplaceViewHolder>() {
    class HistoricalplaceViewHolder(private val binding:ItemHistoricalPlaceBinding,private val clickListener: OnItemClickListener):RecyclerView.ViewHolder(binding.root) {
        fun bind(historicalplace: HistoricalPlaceItem){
            binding.apply {

                txtTitleId1.text = historicalplace.name
                txtDescriptionId.text  = "Place : "+historicalplace.place
                Glide.with(itemView.context)
                    .load(historicalplace.picture)
                    .into(imageId)
                itemView.setOnClickListener {
                    clickListener.onItemClick(adapterPosition)
                }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoricalPlaceAdapter.HistoricalplaceViewHolder {
        val binding = ItemHistoricalPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoricalplaceViewHolder(binding,clickListener)
    }


    override fun onBindViewHolder(
        holder: HistoricalPlaceAdapter.HistoricalplaceViewHolder,
        position: Int
    ) {
        val historicalplace = historicalplaces[position]
        holder.bind(historicalplace)
    }

    override fun getItemCount(): Int {
        return historicalplaces.size
    }
}