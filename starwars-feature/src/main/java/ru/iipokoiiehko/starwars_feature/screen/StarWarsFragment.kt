package ru.iipokoiiehko.starwars_feature.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_star_wars.*
import ru.iipokoiiehko.main_core.App
import ru.iipokoiiehko.main_core.BackPressListener
import ru.iipokoiiehko.main_core_ui.ArchBaseDiFragment
import ru.iipokoiiehko.starwars_feature.R
import ru.iipokoiiehko.starwars_feature.di.StarWarsComponent

class StarWarsFragment : ArchBaseDiFragment<StarWarsViewModel>(R.layout.fragment_star_wars),
    BackPressListener {

    private val viewModel by viewModels<StarWarsViewModel> { viewModeFactory }

    private val adapter = StartWarsAdapter()

    override fun inject() = StarWarsComponent.Initializer
        .init((requireActivity().applicationContext as App).getAppComponent())
        .inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()
        bindView()
        setupListeners()
    }

    private fun bindView() {
        viewModel.peoplesLiveData bindTo { peoples ->
            adapter.submitList(peoples.map { it.name })
        }

        viewModel.loading bindTo {
            swipeRefresh.isRefreshing = it
        }

        viewModel.error
            .subscribe {
                AlertDialog.Builder(requireContext())
                    .setMessage(it.localizedMessage)
                    .setPositiveButton(android.R.string.ok,null)
                    .show()
            }
            .untilDestroyView()
    }

    private fun setupListeners() {
        swipeRefresh.setOnRefreshListener {
            viewModel.loadData()
        }
    }

    private fun setupRecycler() {
        recycler.adapter = adapter
    }

    override fun onBackPressed(): Boolean = childFragmentManager.popBackStackImmediate()

    companion object {

        fun newInstance() = StarWarsFragment()
    }
}