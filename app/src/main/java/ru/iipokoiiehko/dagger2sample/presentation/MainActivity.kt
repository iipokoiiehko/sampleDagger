package ru.iipokoiiehko.dagger2sample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.iipokoiiehko.dagger2sample.R
import ru.iipokoiiehko.dagger2sample.SampleApplication
import ru.iipokoiiehko.dagger2sample.navigation.BackPressListener
import ru.iipokoiiehko.dagger2sample.navigation.Screens
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private val navigator = AppNavigator(this, CONTAINER_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        SampleApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            router.navigateTo(Screens.rootScreen())
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
        if (fragment != null && fragment is BackPressListener && fragment.onBackPressed()) {
            return
        }

        super.onBackPressed()
    }

    companion object {

        private const val CONTAINER_ID = R.id.mainContainer
    }
}