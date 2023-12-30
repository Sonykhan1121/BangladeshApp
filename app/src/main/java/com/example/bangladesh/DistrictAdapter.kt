package com.example.bangladesh

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bangladesh.databinding.ItemDistrictBinding

class DistrictAdapter(private val districts:List<DistrictItem>) :RecyclerView.Adapter<DistrictAdapter.DistrictViewHolder>() {
    class DistrictViewHolder(private val binding:ItemDistrictBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(district:DistrictItem)
        {
            binding.apply {

                txtTitleId1.text = district.id.toString()+") "+district.name
                txtTitleId2.text = "("+district.bnName+")"
                txtDescriptionId.text = "Latitude and Longitude : \n"+district.lat.toString()+" , "+district.long.toString()

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DistrictAdapter.DistrictViewHolder {
        val binding = ItemDistrictBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DistrictViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DistrictAdapter.DistrictViewHolder, position: Int) {
        val district = districts[position]
        holder.bind(district)
    }

    override fun getItemCount(): Int {
        return districts.size
    }

}