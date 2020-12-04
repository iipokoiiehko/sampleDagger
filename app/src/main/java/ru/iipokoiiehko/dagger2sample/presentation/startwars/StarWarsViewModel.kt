package ru.iipokoiiehko.dagger2sample.presentation.startwars

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.iipokoiiehko.dagger2sample.core.gateway.StarWarsGateway
import ru.iipokoiiehko.dagger2sample.domain.model.starwars.BasePeople
import ru.iipokoiiehko.dagger2sample.presentation.base.BaseViewModel
import ru.iipokoiiehko.dagger2sample.presentation.utils.onLoading
import timber.log.Timber
import javax.inject.Inject

class StarWarsViewModel @Inject constructor (
    private val starWarsGateway: StarWarsGateway
) : BaseViewModel() {

    val peoplesLiveData = MutableLiveData<List<BasePeople>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Throwable>()

    init {
        loadData()
    }

    fun loadData() {
        starWarsGateway.getBasePeoples()
            .observeOn(AndroidSchedulers.mainThread())
            .onLoading(loading)
            .subscribe({ peoples ->
                peoplesLiveData.value = peoples
            }, {
                Timber.e(it)
                error.value = it
            })
            .untilCleared()
    }
}