package ru.iipokoiiehko.dagger2sample.di.modules.network

import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.RickAndMortyWebApi
import ru.iipokoiiehko.dagger2sample.di.RickAndMorty
import ru.iipokoiiehko.dagger2sample.di.modules.network.NetworkModule.Companion.CONNECT_TIMEOUT
import ru.iipokoiiehko.dagger2sample.di.modules.network.NetworkModule.Companion.READ_TIMEOUT
import ru.iipokoiiehko.dagger2sample.di.modules.network.NetworkModule.Companion.WRITE_TIMEOUT
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class RickAndMortyNetworkModule {

    @Provides
    @Singleton
    @RickAndMorty
    fun provideOkHttpClient(
        okHttpClient: OkHttpClient,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return okHttpClient.newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRickAndMortyRetrofitApi(
        @RickAndMorty
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RickAndMortyWebApi::class.java)

    companion object {

        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}