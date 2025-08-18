package com.yerali.navigation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yerali.navigation.data.ImageResponse
import com.yerali.navigation.databinding.FragmentRecyclerAdapterBinding

class RecyclerAdapter():RecyclerView.Adapter<RecyclerAdapter.ExampleViewHolder>() {
    private val adapterList = mutableListOf<ImageResponse>()
    inner class ExampleViewHolder(
        private val binding: FragmentRecyclerAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: ImageResponse) {
            binding.textimage.text = item.author
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val binding = FragmentRecyclerAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d("onCreateViewHolder", "$")
        return ExampleViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.onBind(adapterList[position])
        Log.d("onBindViewHolder", "2")
    }
    fun submitList(list:List<ImageResponse>){
        adapterList.addAll(list)
        Log.d("submitList", "$list")
    }
    override fun getItemCount(): Int {
        Log.d("getItemCount", "4")
        return adapterList.size
    }

}
