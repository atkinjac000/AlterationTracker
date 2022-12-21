package com.example.alterationtracker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alterationtracker.databinding.FragmentNewAlterationBinding

class NewAlteration : Fragment() {

    companion object {
        fun newInstance() = NewAlteration()
    }

    private lateinit var viewModel: NewAlterationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewAlterationBinding.inflate(inflater, container, false)
        val viewModel = NewAlterationViewModel()

        binding.saveAlteration.setOnClickListener {
            viewModel.createAlteration(binding.customerNameInput.text.toString(), binding.suitAlterationsInput.text.toString(), binding.pantAlterationsInput.text.toString())
        }

        viewModel.done.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigateUp()
            }
        }
        return binding.root
    }
}