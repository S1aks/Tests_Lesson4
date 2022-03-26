package com.geekbrains.tests.di

import com.geekbrains.tests.App
import com.geekbrains.tests.presenter.RepositoryContract
import com.geekbrains.tests.repository.GitHubApi
import com.geekbrains.tests.repository.GitHubRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<GitHubApi> {
        Retrofit.Builder()
            .baseUrl(App.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)
    }
    single<RepositoryContract> { GitHubRepository(get()) }
}