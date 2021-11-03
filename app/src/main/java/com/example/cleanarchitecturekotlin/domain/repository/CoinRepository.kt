package com.example.cleanarchitecturekotlin.domain.repository

import com.example.cleanarchitecturekotlin.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecturekotlin.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId : String) : CoinDetailDto
}