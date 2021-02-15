package ru.iipokoiiehko.dagger2sample.presentation.rickandmorty

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_rick_and_morty.*
import ru.iipokoiiehko.dagger2sample.R
import ru.iipokoiiehko.dagger2sample.SampleApplication
import ru.iipokoiiehko.dagger2sample.di.modules.viewmodel.DaggerViewModelFactory
import ru.iipokoiiehko.dagger2sample.navigation.BackPressListener
import ru.iipokoiiehko.dagger2sample.presentation.base.ArchBaseDiFragment
import ru.iipokoiiehko.dagger2sample.presentation.startwars.StarWarsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class RickAndMortyFragment :
    ArchBaseDiFragment<RickAndMortyViewModel>(R.layout.fragment_rick_and_morty), BackPressListener {

    private val viewModel by viewModels<RickAndMortyViewModel> { viewModeFactory }
    private val adapter: RickAndMortyAdapter = RickAndMortyAdapter()

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
                    .setPositiveButton(android.R.string.ok,null)
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