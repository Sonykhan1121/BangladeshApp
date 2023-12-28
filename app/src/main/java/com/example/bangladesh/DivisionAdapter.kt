package com.example.bangladesh
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangladesh.databinding.ItemDivisionBinding

class DivisionAdapter(private val divisions: List<DivisionItem>) :
    RecyclerView.Adapter<DivisionAdapter.DivisionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DivisionViewHolder {
        val binding =
            ItemDivisionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DivisionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DivisionViewHolder, position: Int) {
        val division = divisions[position]
        holder.bind(division)
    }

    override fun getItemCount(): Int {
        return divisions.size
    }

    class DivisionViewHolder(private val binding: ItemDivisionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(division: DivisionItem) {
            binding.apply {
                // Set the data to the views using ViewBinding
                txtTitleId1.text = division.id.toString()+") "+division.name
                txtTitleId2.text = "("+division.bnName+")"
                txtDescriptionId.text = "Latitude and Longitude : \n"+division.lat.toString()+" , "+division.long.toString()
                Glide.with(itemView.context)
                    .load(division.picture)
                    .into(imageId)

                // You can set other views based on your DivisionItem properties
            }
        }
    }
}
