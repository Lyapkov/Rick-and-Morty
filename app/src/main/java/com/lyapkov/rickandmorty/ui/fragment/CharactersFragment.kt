package com.lyapkov.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyapkov.rickandmorty.databinding.FragmentCharactersBinding
import com.lyapkov.rickandmorty.mvp.presenter.CharactersPresenter
import com.lyapkov.rickandmorty.mvp.view.CharactersView
import com.lyapkov.rickandmorty.ui.App
import com.lyapkov.rickandmorty.ui.BackButtonListener
import com.lyapkov.rickandmorty.ui.adapter.CharactersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CharactersFragment : MvpAppCompatFragment(), CharactersView, BackButtonListener {
    companion object {
        fun newInstance() = CharactersFragment()
    }

    val presenter: CharactersPresenter by moxyPresenter {
        CharactersPresenter().apply { App.instance.appComponent.inject(this) }
    }

    var adapter: CharactersRVAdapter? = null
    private var vb: FragmentCharactersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(inflater, container, false).also { vb = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvCharacters?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adapter = CharactersRVAdapter(presenter.charactersListPresenter)
            .apply { App.instance.appComponent.inject(this) }
        vb?.rvCharacters?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}