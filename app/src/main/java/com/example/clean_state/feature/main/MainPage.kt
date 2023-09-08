package com.example.clean_state.feature.main

import MainPageEvent
import com.example.clean_state.feature.main.viewmodel.MainPageViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.clean_state.core.FormzStatus

@Composable
fun MainPage(viewModel: MainPageViewModel = hiltViewModel<MainPageViewModel>()) {

    val state = viewModel.state.collectAsState().value

    if (state.status == FormzStatus.Loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else if(state.status==FormzStatus.Loaded){
        Box(modifier = Modifier.fillMaxSize()) {
            Text("Success",modifier=Modifier.align(Alignment.Center))
            print(state.data.toString())
        }

    }else if(state.status==FormzStatus.Error){
        Box(modifier = Modifier.fillMaxSize()) {
            Text("Error: ${state.errorMessage}",modifier=Modifier.align(Alignment.Center))
        }
    }

}