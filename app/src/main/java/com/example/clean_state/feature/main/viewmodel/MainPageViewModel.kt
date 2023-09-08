package com.example.clean_state.feature.main.viewmodel

import BaseViewModel
import MainPageEvent
import MainPageState
import ResultData
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.clean_state.core.FormzStatus
import com.example.clean_state.feature.main.data.repository.MainPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainPageViewModel @Inject constructor(private val mainPagerRepository: MainPageRepository) :
    ViewModel()
     {
     val state: MutableStateFlow<MainPageState>
        get() = state


         init {
             onEvent(MainPageEvent.LoadData)
         }

     fun onEvent(event: MainPageEvent) {
        when (event) {
            MainPageEvent.LoadData -> {
                mainPagerRepository.getUsers().onEach {
                    when (it) {
                        is ResultData.Loading -> {
                            state.tryEmit(state.value.copy(status = FormzStatus.Loading))
                        }

                        is ResultData.Success -> {
                            state.tryEmit(
                                state.value.copy(
                                    status = FormzStatus.Loaded,
                                    data = it.data
                                )
                            )
                        }

                        is ResultData.Fail -> {
                            state.tryEmit(
                                state.value.copy(
                                    status = FormzStatus.Error,
                                    errorMessage = it.throwable.toString()
                                )
                            )
                        }

                        else -> {
                            Log.d("", "ERROR ON RESULT DATA VIEW MODEL")
                        }
                    }


                }


            }


            else -> {
                Log.d("", "Undefined MainPage ui event")
            }
        }
    }


}


