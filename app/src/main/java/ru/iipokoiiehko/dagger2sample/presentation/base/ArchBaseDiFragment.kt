package ru.iipokoiiehko.dagger2sample.presentation.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.iipokoiiehko.dagger2sample.di.modules.viewmodel.DaggerViewModelFactory
import ru.iipokoiiehko.dagger2sample.presentation.startwars.StarWarsViewModel
import javax.inject.Inject

abstract class ArchBaseDiFragment<VM: ViewModel>(@LayoutRes contentLayoutId: Int) : BaseDiFragment(contentLayoutId) {

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory<VM>

    infix fun <T> LiveData<T>.bindTo(consumer: (T) -> Unit) {
        this.observe(viewLifecycleOwner, { consumer(it) })
    }
}