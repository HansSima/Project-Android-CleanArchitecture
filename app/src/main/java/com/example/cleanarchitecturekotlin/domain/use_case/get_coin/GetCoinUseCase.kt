package com.example.cleanarchitecturekotlin.domain.use_case.get_coin

import com.example.cleanarchitecturekotlin.common.Resource
import com.example.cleanarchitecturekotlin.data.remote.dto.toCoin
import com.example.cleanarchitecturekotlin.data.remote.dto.toCoinDetail
import com.example.cleanarchitecturekotlin.domain.model.Coin
import com.example.cleanarchitecturekotlin.domain.model.CoinDetail
import com.example.cleanarchitecturekotlin.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException){
            emit(Resource.Error<CoinDetail>("Could't reach server. Check your internet connection"))
        }
    }
}