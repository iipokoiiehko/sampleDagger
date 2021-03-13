package ru.iipokoiiehko.starwars_feature.screen

import androidx.lifecycle.MutableLiveData
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.iipokoiiehko.dagger2sample.presentation.utils.onLoading
import ru.iipokoiiehko.main_core.models.BasePeople
import ru.iipokoiiehko.main_core_ui.BaseViewModel
import ru.iipokoiiehko.starwars_feature.interactors.StartWarsInteractor
import javax.inject.Inject

class StarWarsViewModel @Inject constructor(
    private val startWarsInteractor: StartWarsInteractor
) : BaseViewModel() {

    val peoplesLiveData = MutableLiveData<List<BasePeople>>()
    val loading = MutableLiveData<Boolean>()
    val error: BehaviorRelay<Throwable> = BehaviorRelay.create()

    init {
        loadData()
    }

    fun loadData() {
        startWarsInteractor.getBasePeoples()
            .observeOn(AndroidSchedulers.mainThread())
            .onLoading(loading)
            .subscribe({ peoples ->
                peoplesLiveData.value = peoples
            }, {
                error.accept(it)
            })
            .untilCleared()
    }
}