package ru.iipokoiiehko.dagger2sample.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.iipokoiiehko.dagger2sample.R
import ru.iipokoiiehko.dagger2sample.di.MainScreenComponent
import ru.iipokoiiehko.main_core_ui.ArchBaseDiActivity
import javax.inject.Inject

class MainActivity : ArchBaseDiActivity<MainViewModel>(R.layout.activity_main) {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, CONTAINER_ID)

    private val viewModel by viewModels<MainViewModel> { viewModeFactory }

    val mainScreenComponent by lazy {
        MainScreenComponent.Initializer
            .init()
    }

    override fun inject() = mainScreenComponent
        .inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.toRoot()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(CONTAINER_ID)
        if (fragment != null && fragment is ru.iipokoiiehko.main_core.BackPressListener && fragment.onBackPressed()) {
            return
        }

        super.onBackPressed()
    }

    companion object {

        private const val CONTAINER_ID = R.id.mainContainer
    }
}