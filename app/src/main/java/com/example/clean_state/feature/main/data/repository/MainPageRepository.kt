package com.example.clean_state.feature.main.data.repository
import ResultData
import com.example.clean_state.feature.main.data.models.UserModelItem
import kotlinx.coroutines.flow.Flow

interface MainPageRepository {
    fun getUsers(): Flow<ResultData<List<UserModelItem>>>
}