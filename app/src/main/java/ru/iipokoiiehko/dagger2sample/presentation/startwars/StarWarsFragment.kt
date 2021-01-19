package ru.iipokoiiehko.dagger2sample.presentation.startwars

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_star_wars.*
import ru.iipokoiiehko.dagger2sample.R
import ru.iipokoiiehko.dagger2sample.SampleApplication
import ru.iipokoiiehko.dagger2sample.di.modules.viewmodel.DaggerViewModelFactory
import ru.iipokoiiehko.dagger2sample.navigation.BackPressListener
import ru.iipokoiiehko.dagger2sample.presentation.base.ArchBaseDiFragment
import javax.inject.Inject

class StarWarsFragment : ArchBaseDiFragment<StarWarsViewModel>(R.layout.fragment_star_wars),
    BackPressListener {

    private val viewModel by viewModels<StarWarsViewModel> { viewModeFactory }

    private val adapter = StartWarsAdapter()

    override fun inject() = SampleApplication.appComponent.inject(this)

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