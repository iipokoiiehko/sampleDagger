package ru.iipokoiiehko.dagger2sample.di.modules.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.iipokoiiehko.dagger2sample.data.api.starwars.StarWarsWebApi
import ru.iipokoiiehko.dagger2sample.di.StarWars
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StarWarsNetworkModule {

    @Provides
    @Singleton
    @StarWars
    fun provideOkHttpClient(
        okHttpClient: OkHttpClient,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ) = okHttpClient.newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .readTimeout(NetworkModule.READ_TIMEOUT, TimeUnit.SECONDS)
        .connectTimeout(NetworkModule.CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(NetworkModule.WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRickAndMortyRetrofitApi(
        @StarWars
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StarWarsWebApi::class.java)


    companion object {

        private const val BASE_URL = "https://www.swapi.tech/api/"
    }
}