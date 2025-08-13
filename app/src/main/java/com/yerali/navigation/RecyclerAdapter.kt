package com.yerali.navigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yerali.navigation.data.ImageResponse
import com.bumptech.glide.Glide
import com.yerali.navigation.databinding.FragmentRecyclerAdapterBinding

class RecyclerAdapter():RecyclerView.Adapter<RecyclerAdapter.ExampleViewHolder>() {
    private val adapterList = mutableListOf<ImageResponse>()
    inner class ExampleViewHolder(
        private val binding: FragmentRecyclerAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ImageResponse) {
            Glide.with(binding.root.context).load(item.downloadUrl).centerCrop().into(binding.imagesrc)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val binding = FragmentRecyclerAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(adapterList[position])
    }
    fun submitList(list:List<ImageResponse>){
        adapterList.addAll(list)
    }
    override fun getItemCount(): Int {
        return adapterList.size
    }

}
