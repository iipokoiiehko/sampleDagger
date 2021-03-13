package ru.iipokoiiehko.rickandmorty_feature.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_rick_and_morty.*
import ru.iipokoiiehko.main_core.App
import ru.iipokoiiehko.main_core.BackPressListener
import ru.iipokoiiehko.main_core_ui.ArchBaseDiFragment
import ru.iipokoiiehko.rickandmorty_feature.R
import ru.iipokoiiehko.rickandmorty_feature.di.RickAndMortyComponent

class RickAndMortyFragment :
    ArchBaseDiFragment<RickAndMortyViewModel>(R.layout.fragment_rick_and_morty),
    BackPressListener {

    private val viewModel by viewModels<RickAndMortyViewModel> { viewModeFactory }
    private val adapter: RickAndMortyAdapter =
        RickAndMortyAdapter()

    override fun inject() = RickAndMortyComponent.Initializer
        .init((requireActivity().applicationContext as App).getAppComponent())
        .inject(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindData()
        setupRecycler()
        setupListeners()
    }

    private fun setupListeners() {
        swipeRefresh.setOnRefreshListener {
            viewModel.loadData()
        }
    }

    private fun bindData() {
        viewModel.charactersLiveData bindTo { peoples ->
            adapter.submitList(peoples.map { it.name })
        }

        viewModel.loading bindTo {
            swipeRefresh.isRefreshing = it
        }

        viewModel.error
            .subscribe {
                AlertDialog.Builder(requireContext())
                    .setMessage(it.localizedMessage)
                    .setPositiveButton(android.R.string.ok, null)
                    .show()
            }
            .untilDestroyView()
    }

    private fun setupRecycler() {
        recycler.adapter = adapter
    }

    override fun onBackPressed(): Boolean = childFragmentManager.popBackStackImmediate()

    companion object {

        fun newInstance() = RickAndMortyFragment()
    }
}