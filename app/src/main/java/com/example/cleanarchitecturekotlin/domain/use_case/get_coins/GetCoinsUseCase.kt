package com.example.cleanarchitecturekotlin.domain.use_case.get_coins

import com.example.cleanarchitecturekotlin.common.Resource
import com.example.cleanarchitecturekotlin.data.remote.dto.toCoin
import com.example.cleanarchitecturekotlin.domain.model.Coin
import com.example.cleanarchitecturekotlin.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException){
            emit(Resource.Error<List<Coin>>("Could't reach server. Check your internet connection"))
        }
    }
}