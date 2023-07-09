package com.example.ventasboletas.ui.List


import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.example.ventasboletas.data.DTO.Eventosresponsidto
import com.example.ventasboletas.data.repository.ConsumirApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


data class ListViewModelListUiState(
    val eventos: List<Eventosresponsidto> = emptyList(),
)

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ConsumirApi
) : ViewModel() {

    private val _uiState = MutableStateFlow( ListViewModelListUiState())
    val uiState: StateFlow<ListViewModelListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {

                it.copy(eventos =repository.geAllapi().sortedBy { it.Nombre } )
            }
        }
    }





}