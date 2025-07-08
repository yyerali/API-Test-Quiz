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
import com.yerali.navigation.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch

class firstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            try{
                val data = RetrofitService.apiService.getFact()
                // классом было бы лучше но так быстрее будто
                val questions = mutableListOf((data.results[0] as Map<String, Any>)["correct_answer"])
                for (item in ((data.results[0] as Map<String, Any>)["incorrect_answers"] as List<*>)) {
                    questions.add(item.toString())
                }
                val askquestions = questions.shuffled()

                binding.fact.text = "${(data.results[0] as Map<String, Any>)["question"]}\n1. ${askquestions[0]}\n2. ${askquestions[1]}\n3. ${askquestions[2]}\n4. ${askquestions[3]}\n"

                binding.button.setOnClickListener {
                    if (binding.editTextText.getText().toString() == (data.results[0] as Map<String, Any>)["correct_answer"]){findNavController().navigate(R.id.action_firstFragment_to_correct)}
                    else if (binding.editTextText.text.toString() == ""){
                        Toast.makeText(requireContext(), "The textbar is empty!", Toast.LENGTH_SHORT).show()}
                    else{findNavController().navigate(R.id.action_firstFragment_to_incorrect)}
                }

            } catch (e:Exception){
                Log.d("AAA", e.message.toString())
            }
        }
    }
}