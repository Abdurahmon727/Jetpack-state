package com.example.clean_state.feature.main.di.com.example.clean_state.feature.main.di

import MainPageRepositoryImpl
import com.example.clean_state.feature.main.data.repository.MainPageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface  RepositoryModule {
//    @Binds
//     fun bindMainPageRepository(impl: MainPageRepositoryImpl): MainPageRepository
}