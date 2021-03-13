package ru.iipokoiiehko.main_core

import ru.iipokoiiehko.main_core.gateways.RickAndMortyGateway
import ru.iipokoiiehko.main_core.gateways.StarWarsGateway

interface ApplicationProvider : GatewayProvider

interface GatewayProvider {

    fun provideRickAndMortyGateway(): RickAndMortyGateway
    fun provideStarWarsGateway(): StarWarsGateway
}