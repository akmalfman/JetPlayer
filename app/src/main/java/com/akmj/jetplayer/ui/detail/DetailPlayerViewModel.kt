package com.akmj.jetplayer.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akmj.jetplayer.data.PlayerRepository
//import com.akmj.jetplayer.model.OrderReward
import com.akmj.jetplayer.model.Player
import com.akmj.jetplayer.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailPlayerViewModel(
    private val repository: PlayerRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Player>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Player>>
        get() = _uiState

    fun getRewardById(id: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getPlayerById(id))
        }
    }
}