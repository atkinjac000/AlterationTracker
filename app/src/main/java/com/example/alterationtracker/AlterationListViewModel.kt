package com.example.alterationtracker

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AlterationListViewModel : ViewModel() {
    val alterations = ObservableArrayList<Alteration>()

    init {
        loadAlterations()
    }

    private fun loadAlterations() {
        viewModelScope.launch {
            val loadedAlterations = AlterationsRepository.getAllAlterations()
            alterations.addAll(loadedAlterations)
        }
    }
}