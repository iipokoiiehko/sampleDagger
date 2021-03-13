package ru.iipokoiiehko.rickandmorty_feature.screen

import androidx.lifecycle.MutableLiveData
import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.iipokoiiehko.rickandmorty_feature.interactors.RickAndMortyInteractor
import ru.iipokoiiehko.main_core.models.Character
import ru.iipokoiiehko.dagger2sample.presentation.utils.onLoading
import ru.iipokoiiehko.main_core_ui.BaseViewModel
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