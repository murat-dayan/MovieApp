package com.example.movieapp.di

import com.example.movieapp.core.utils.Constants
import com.example.movieapp.data.remote.api.MoviesApi
import com.example.movieapp.data.remote.repository.RepositoryImpl
import com.example.movieapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesRetrofitInstance() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun providesMoviesApi(retrofit: Retrofit): MoviesApi= retrofit.create(MoviesApi::class.java)

    @Provides
    @Singleton
    fun providesRepository(moviesApi: MoviesApi): Repository{
        return RepositoryImpl(moviesApi)
    }


}