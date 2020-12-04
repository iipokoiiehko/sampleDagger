package ru.iipokoiiehko.dagger2sample.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    protected fun Disposable.untilCleared() = compositeDisposable.add(this)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}