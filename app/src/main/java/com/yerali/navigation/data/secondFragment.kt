package com.yerali.navigation.data

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.yerali.navigation.R
import com.yerali.navigation.RecyclerAdapter
import com.yerali.navigation.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch

class secondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            try {
                val response = RetrofitService.apiService.getImages()
                Log.d("BBB", response[0].author)
                binding.texttext.text = response[0].author
            } catch (e:Exception){
                Log.d("AAA", e.message.toString())
            }
        }
    }
}