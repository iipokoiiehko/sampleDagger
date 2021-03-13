package ru.iipokoiiehko.dagger2sample.di

import dagger.Component
import ru.iipokoiiehko.dagger2sample.di.modules.CiceroneModule
import ru.iipokoiiehko.dagger2sample.presentation.MainActivity
import ru.iipokoiiehko.dagger2sample.presentation.root.RootFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class
    ]
)
interface MainScreenComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: RootFragment)

    class Initializer private constructor() {

        companion object {
            fun init(): MainScreenComponent {

                return DaggerMainScreenComponent.builder()
                    .build()
            }
        }
    }
}