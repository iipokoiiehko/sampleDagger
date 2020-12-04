package ru.iipokoiiehko.dagger2sample.di.modules

import dagger.Module
import dagger.Provides
import ru.iipokoiiehko.dagger2sample.core.gateway.RickAndMortyGateway
import ru.iipokoiiehko.dagger2sample.core.gateway.StarWarsGateway
import ru.iipokoiiehko.dagger2sample.data.api.rickandmorty.gateway.RickAndMortyGatewayImpl
import ru.iipokoiiehko.dagger2sample.data.api.starwars.gateway.StarWarsGatewayImpl
import javax.inject.Singleton

@Module
class InteractorsModule {

    @Provides
    @Singleton
    fun provideRickAndMortyGateway(impl: RickAndMortyGatewayImpl): RickAndMortyGateway = impl

    @Provides
    @Singleton
    fun provideStarWarsGateway(impl: StarWarsGatewayImpl): StarWarsGateway = impl
}