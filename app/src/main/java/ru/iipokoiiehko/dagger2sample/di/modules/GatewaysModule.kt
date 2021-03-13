package ru.iipokoiiehko.dagger2sample.di.modules

import dagger.Binds
import dagger.Module
import ru.iipokoiiehko.rickandmorty_api.gateway.RickAndMortyGatewayImpl
import ru.iipokoiiehko.main_core.gateways.RickAndMortyGateway
import ru.iipokoiiehko.starwars_api.gateway.StarWarsGatewayImpl
import ru.iipokoiiehko.main_core.gateways.StarWarsGateway
import javax.inject.Singleton

@Module
interface GatewaysModule {

    @Binds
    @Singleton
    fun bindsRickAndMortyGateway(impl: RickAndMortyGatewayImpl): RickAndMortyGateway

    @Binds
    @Singleton
    fun bindsStarWarsGateway(impl: StarWarsGatewayImpl): StarWarsGateway
}