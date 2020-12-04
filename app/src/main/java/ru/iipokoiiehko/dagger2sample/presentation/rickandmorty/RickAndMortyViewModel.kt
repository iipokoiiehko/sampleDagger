package ru.iipokoiiehko.dagger2sample.presentation.rickandmorty

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.iipokoiiehko.dagger2sample.core.gateway.RickAndMortyGateway
import ru.iipokoiiehko.dagger2sample.domain.model.rickandmorty.Character
import ru.iipokoiiehko.dagger2sample.presentation.base.BaseViewModel
import ru.iipokoiiehko.dagger2sample.presentation.utils.onLoading
import javax.inject.Inject

class RickAndMortyViewModel @Inject constructor(
    private val rickAndMortyGateway: RickAndMortyGateway
) : BaseViewModel() {

    val charactersLiveData = MutableLiveData<List<Character>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Throwable>()

    init {
        loadData()
    }

    fun loadData() {
        rickAndMortyGateway.getCharacter()
            .observeOn(AndroidSchedulers.mainThread())
            .onLoading(loading)
            .subscribe({ characters ->
                charactersLiveData.value = characters
            }, {
                error.value = it
            })
            .untilCleared()
    }
}