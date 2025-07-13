package com.example.videoapplication.presentation.viewModel.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videoapplication.utils.EventBus
import kotlinx.coroutines.launch

fun ViewModel.sendEvent(event:Any){
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}