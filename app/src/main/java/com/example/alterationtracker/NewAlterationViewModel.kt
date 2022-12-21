package com.example.alterationtracker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewAlterationViewModel : ViewModel() {
    val done = MutableLiveData(false)

    fun createAlteration(name: String, suit: String, pant: String) {
        viewModelScope.launch {
            val alteration = Alteration(customerName = name, suitAlterations = suit, pantAlterations = pant)
            AlterationsRepository.createAlteration(alteration)
            done.value = true
        }
    }
}