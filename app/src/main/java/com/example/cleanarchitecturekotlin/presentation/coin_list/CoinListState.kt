package com.example.cleanarchitecturekotlin.presentation.coin_list

import com.example.cleanarchitecturekotlin.domain.model.Coin
import java.util.Collections.emptyList

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)