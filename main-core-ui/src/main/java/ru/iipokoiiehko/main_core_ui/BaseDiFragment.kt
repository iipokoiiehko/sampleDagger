package ru.iipokoiiehko.main_core_ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseDiFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    private val compositeDisposable = CompositeDisposable()

    abstract fun inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        inject()
        super.onViewCreated(view, savedInstanceState)
    }

    protected fun Disposable.untilDestroyView() = compositeDisposable.add(this)

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }
}