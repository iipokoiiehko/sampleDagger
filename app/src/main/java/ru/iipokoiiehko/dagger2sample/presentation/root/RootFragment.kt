package ru.iipokoiiehko.dagger2sample.presentation.root

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_navigation.*
import ru.iipokoiiehko.dagger2sample.R
import ru.iipokoiiehko.dagger2sample.presentation.MainActivity
import ru.iipokoiiehko.main_core_ui.ArchBaseDiFragment

class RootFragment : ArchBaseDiFragment<RootViewModel>(R.layout.fragment_navigation) {

    private val viewModel by viewModels<RootViewModel> { viewModeFactory }

    override fun inject() = (requireActivity() as MainActivity).mainScreenComponent
        .inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()
    }

    private fun setupListener() {
        button_rickAndMorty.setOnClickListener {
            viewModel.toRickAndMorty()
        }
        button_starWars.setOnClickListener {
            viewModel.toStarWars()
        }
    }

    companion object {

        fun newInstance() = RootFragment()
    }
}