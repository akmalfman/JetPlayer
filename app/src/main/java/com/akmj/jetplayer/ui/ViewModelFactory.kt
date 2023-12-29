package com.akmj.jetplayer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akmj.jetplayer.JetPlayersViewModel
import com.akmj.jetplayer.data.PlayerRepository

class ViewModelFactory(private val repository: PlayerRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JetPlayersViewModel::class.java)) {
            return JetPlayersViewModel(repository) as T
        }
//        else if (modelClass.isAssignableFrom(DetailRewardViewModel::class.java)) {
//            return DetailRewardViewModel(repository) as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}