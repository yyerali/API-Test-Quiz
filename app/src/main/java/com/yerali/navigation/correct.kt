package com.yerali.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yerali.navigation.data.RetrofitService
import com.yerali.navigation.databinding.FragmentCorrectBinding
import kotlinx.coroutines.launch

class correct : Fragment() {

    private lateinit var binding: FragmentCorrectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCorrectBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_correct_to_firstFragment)
        }
    }
}