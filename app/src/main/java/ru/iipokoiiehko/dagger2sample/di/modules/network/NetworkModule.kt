package ru.iipokoiiehko.dagger2sample.di.modules.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module(
    includes = [
        RickAndMortyNetworkModule::class,
        StarWarsNetworkModule::class
    ]
)
class NetworkModule {

    @Provides
    @Singleton
    fun provideBaseOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

    companion object {

        const val READ_TIMEOUT = 120L
        const val WRITE_TIMEOUT = 120L
        const val CONNECT_TIMEOUT = 120L
    }
}