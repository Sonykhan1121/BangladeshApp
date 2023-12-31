package com.example.bangladesh
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.bangladesh.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangladesh.databinding.ItemDivisionBinding

class DivisionAdapter(val divisions: List<DivisionItem>, private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<DivisionAdapter.DivisionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DivisionViewHolder {
        val binding =
            ItemDivisionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DivisionViewHolder(binding,clickListener)
    }

    override fun onBindViewHolder(holder: DivisionViewHolder, position: Int) {
        val division = divisions[position]
        holder.bind(division)
    }

    override fun getItemCount(): Int {
        return divisions.size
    }

    class DivisionViewHolder(private val binding: ItemDivisionBinding,private val clickListener:OnItemClickListener) :
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
                itemView.setOnClickListener {
                    // Trigger the onItemClick method when an item is clicked
                    clickListener.onItemClick(adapterPosition)
                }

                // You can set other views based on your DivisionItem properties
            }
        }
    }
}



