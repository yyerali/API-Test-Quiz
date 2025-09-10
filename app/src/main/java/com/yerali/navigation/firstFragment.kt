package com.yerali.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.yerali.navigation.data.RetrofitService
import com.yerali.navigation.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch

class firstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        binding.button.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val response = RetrofitService.apiService.getImages()
                    Log.d("BBB", response.toString())
                    adapter.submitList(response)
                } catch (e:Exception){
                    Log.d("AAA", e.message.toString())
                }
            }
        }
    }
}