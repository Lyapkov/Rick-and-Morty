package com.lyapkov.rickandmorty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.lyapkov.rickandmorty.databinding.FragmentMenuBinding
import com.lyapkov.rickandmorty.mvp.presenter.MenuPresenter
import com.lyapkov.rickandmorty.mvp.view.MenuView
import com.lyapkov.rickandmorty.ui.App
import com.lyapkov.rickandmorty.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MenuFragment : MvpAppCompatFragment(), MenuView, BackButtonListener {
    companion object {
        fun newInstance() = MenuFragment()
    }

    val presenter: MenuPresenter by moxyPresenter {
        MenuPresenter().apply { App.instance.appComponent.inject(this) }
    }

    private var vb: FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentMenuBinding.inflate(inflater, container, false).also {
            vb = it
            vb?.personButton?.setOnClickListener { presenter.transitionCharacters() }
        }.root

    override fun backPressed() = presenter.backPressed()
}