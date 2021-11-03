package com.example.cleanarchitecturekotlin.presentation.coin_detail

import com.example.cleanarchitecturekotlin.domain.model.Coin
import com.example.cleanarchitecturekotlin.domain.model.CoinDetail
import java.util.Collections.emptyList

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coin: CoinDetail ?= null,
    val error: String = ""
)