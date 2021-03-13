package ru.iipokoiiehko.dagger2sample.presentation.utils

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single


fun <T> Single<T>.onLoading(mutableLiveData: MutableLiveData<Boolean>): Single<T> {
    return this
        .doOnSubscribe { mutableLiveData.postValue(true) }
        .doAfterTerminate { mutableLiveData.postValue(false) }
}
