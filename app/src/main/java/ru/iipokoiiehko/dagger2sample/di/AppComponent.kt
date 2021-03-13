package ru.iipokoiiehko.dagger2sample.di

import dagger.Component
import ru.iipokoiiehko.dagger2sample.di.modules.ApplicationScope
import ru.iipokoiiehko.main_core.ApplicationProvider
import javax.inject.Singleton

@ApplicationScope
@Component(
    dependencies = [
        GatewayProviderComponent::class
    ]
)
interface AppComponent : ApplicationProvider {

    class Initializer private constructor() {

        companion object {
            fun init(): AppComponent {

                val gatewayProviderComponent = GatewayProviderComponent.Initializer.init()

                return DaggerAppComponent.builder()
                    .gatewayProviderComponent(gatewayProviderComponent)
                    .build()
            }
        }
    }
}