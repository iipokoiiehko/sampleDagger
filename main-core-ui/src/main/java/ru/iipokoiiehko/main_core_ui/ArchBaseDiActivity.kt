package ru.iipokoiiehko.main_core_ui

import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import ru.iipokoiiehko.main_core_ui.di.DaggerViewModelFactory
import javax.inject.Inject

abstract class ArchBaseDiActivity<VM: ViewModel>(
    @LayoutRes
    contentLayoutId: Int
) : BaseDiActivity(contentLayoutId) {

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory<VM>
}