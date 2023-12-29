package com.akmj.jetplayer.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akmj.jetplayer.model.Player
import com.akmj.jetplayer.model.PlayersData

class PlayerRepository {


    fun getPlayers(): List<Player> {
        return PlayersData.players
    }

    fun searchPlayers(query: String): List<Player>{
        return PlayersData.players.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getPlayerById(id: String): Player {
        return PlayersData.players.first() {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: PlayerRepository? = null

        fun getInstance(): PlayerRepository =
            instance ?: synchronized(this) {
                PlayerRepository().apply {
                    instance = this
                }
            }
    }
}