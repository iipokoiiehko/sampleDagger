package ru.iipokoiiehko.dagger2sample.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import ru.iipokoiiehko.dagger2sample.SampleApplication

abstract class BaseDiFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract fun inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        inject()
        super.onViewCreated(view, savedInstanceState)
    }
}