package ru.iipokoiiehko.dagger2sample.presentation.rickandmorty

import androidx.lifecycle.MutableLiveData
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.iipokoiiehko.dagger2sample.core.gateway.RickAndMortyGateway
import ru.iipokoiiehko.dagger2sample.domain.interactors.RickAndMortyInteractor
import ru.iipokoiiehko.dagger2sample.domain.model.rickandmorty.Character
import ru.iipokoiiehko.dagger2sample.presentation.base.BaseViewModel
import ru.iipokoiiehko.dagger2sample.presentation.utils.onLoading
import javax.inject.Inject

class RickAndMortyViewModel @Inject constructor(
    private val rickAndMortyInteractor: RickAndMortyInteractor
) : BaseViewModel() {

    val charactersLiveData = MutableLiveData<List<Character>>()
    val loading = MutableLiveData<Boolean>()
    val error: PublishRelay<Throwable> = PublishRelay.create()

    init {
        loadData()
    }

    fun loadData() {
        rickAndMortyInteractor.getCharacter()
            .observeOn(AndroidSchedulers.mainThread())
            .onLoading(loading)
            .subscribe({ characters ->
                charactersLiveData.value = characters
            }, {
                error.accept(it)
            })
            .untilCleared()
    }
}