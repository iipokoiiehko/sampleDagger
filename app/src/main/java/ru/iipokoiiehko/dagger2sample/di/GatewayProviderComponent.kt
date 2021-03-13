package ru.iipokoiiehko.dagger2sample.di

import dagger.Component
import ru.iipokoiiehko.dagger2sample.di.modules.GatewaysModule
import ru.iipokoiiehko.dagger2sample.di.modules.network.NetworkModule
import ru.iipokoiiehko.main_core.ApplicationProvider
import ru.iipokoiiehko.main_core.GatewayProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        GatewaysModule::class
    ]
)
interface GatewayProviderComponent : GatewayProvider{

    class Initializer private constructor() {

        companion object {
            fun init(): GatewayProviderComponent {

                return DaggerGatewayProviderComponent.builder()
                    .build()
            }
        }
    }
}