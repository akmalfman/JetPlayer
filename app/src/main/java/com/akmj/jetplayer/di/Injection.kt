package com.akmj.jetplayer.di

import com.akmj.jetplayer.data.PlayerRepository


object Injection {
    fun provideRepository(): PlayerRepository {
        return PlayerRepository.getInstance()
    }
}