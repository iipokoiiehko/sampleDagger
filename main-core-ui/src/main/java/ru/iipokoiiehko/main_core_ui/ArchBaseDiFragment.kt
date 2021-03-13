package ru.iipokoiiehko.main_core_ui

import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.iipokoiiehko.main_core_ui.di.DaggerViewModelFactory
import javax.inject.Inject

abstract class ArchBaseDiFragment<VM : ViewModel>(
    @LayoutRes
    contentLayoutId: Int
) : BaseDiFragment(contentLayoutId) {

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory<VM>

    infix fun <T> LiveData<T>.bindTo(consumer: (T) -> Unit) {
        this.observe(viewLifecycleOwner, { consumer(it) })
    }
}