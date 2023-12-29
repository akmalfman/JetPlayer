package com.akmj.jetplayer


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akmj.jetplayer.data.PlayerRepository
import com.akmj.jetplayer.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class JetPlayersViewModel(private val repository: PlayerRepository) : ViewModel() {
    private val _groupedPlayers = MutableStateFlow(
        repository.getPlayers()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedPlayers: StateFlow<Map<Char, List<Player>>> get() = _groupedPlayers

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedPlayers.value = repository.searchPlayers(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}