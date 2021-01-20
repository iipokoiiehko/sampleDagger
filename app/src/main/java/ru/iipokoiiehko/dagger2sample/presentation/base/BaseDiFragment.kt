package ru.iipokoiiehko.dagger2sample.presentation.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

abstract class BaseDiFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId),
    HasAndroidInjector {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    protected fun Disposable.untilDestroyView() = compositeDisposable.add(this)

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }
}