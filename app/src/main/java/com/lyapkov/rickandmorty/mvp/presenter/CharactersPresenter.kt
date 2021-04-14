package com.lyapkov.rickandmorty.mvp.presenter

import com.github.terrakok.cicerone.Router
import com.lyapkov.rickandmorty.mvp.model.entity.Character
import com.lyapkov.rickandmorty.mvp.model.navigation.IScreens
import com.lyapkov.rickandmorty.mvp.model.repo.ICharactersRepo
import com.lyapkov.rickandmorty.mvp.presenter.list.ICharacterListPresenter
import com.lyapkov.rickandmorty.mvp.view.CharactersView
import com.lyapkov.rickandmorty.mvp.view.list.CharacterItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import javax.inject.Inject

class CharactersPresenter : MvpPresenter<CharactersView>() {

    @Inject
    lateinit var charactersRepo: ICharactersRepo
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens
    @Inject
    lateinit var uiScheduler: Scheduler

    class CharactersListPresenter : ICharacterListPresenter {
        val characters = mutableListOf<Character>()
        override var itemClickListener: ((CharacterItemView) -> Unit)? = null

        override fun bindView(view: CharacterItemView) {
            val character = characters[view.pos]
            character.name.let { view.setName(it) }
            character.status.let { view.setStatus(it) }
            character.species.let { view.setSpecies(it) }
            character.type.let { view.setType(it) }
            character.gender.let { view.setGender(it) }
            character.image.let { view.loadAvatar(it) }
        }

        override fun getCount() = characters.size

    }

    val charactersListPresenter = CharactersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() {
        charactersRepo.getCharacters()
            ?.observeOn(uiScheduler)
            ?.subscribe({ result ->
                charactersListPresenter.characters.clear()
                charactersListPresenter.characters.addAll(result)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}