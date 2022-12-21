package com.example.alterationtracker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alterationtracker.databinding.FragmentAlterationListBinding

class AlterationList : Fragment() {

    companion object {
        fun newInstance() = AlterationList()
    }

    private lateinit var viewModel: AlterationListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAlterationListBinding.inflate(inflater, container, false)
        val viewModel = AlterationListViewModel()

        binding.alterationList.adapter = AlterationsAdapter(viewModel.alterations)
        binding.alterationList.layoutManager = LinearLayoutManager(context)

        binding.addAlteration.setOnClickListener {
            findNavController().navigate(R.id.action_alterationList_to_newAlteration)
        }
        return binding.root
    }
}