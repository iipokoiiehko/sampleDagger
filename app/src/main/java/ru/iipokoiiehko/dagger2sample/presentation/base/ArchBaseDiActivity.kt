package ru.iipokoiiehko.dagger2sample.presentation.base

import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.iipokoiiehko.dagger2sample.di.modules.viewmodel.DaggerViewModelFactory
import javax.inject.Inject

abstract class ArchBaseDiActivity<VM: ViewModel>(
    @LayoutRes
    contentLayoutId: Int
) : BaseDiActivity(contentLayoutId) {

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory<VM>
}