package ru.iipokoiiehko.dagger2sample.di.modules

import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CiceroneModule {

    @Provides
    @Singleton
    fun provideCicerone() = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
}