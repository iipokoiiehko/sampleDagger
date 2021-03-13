package ru.iipokoiiehko.main_core_ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class DaggerViewModelFactory<VM: ViewModel> @Inject constructor(
    private val viewModelProvider: Provider<VM>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModelProvider.get() as T
}