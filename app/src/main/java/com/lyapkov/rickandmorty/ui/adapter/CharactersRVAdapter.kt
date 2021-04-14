package com.lyapkov.rickandmorty.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lyapkov.rickandmorty.databinding.ItemCharacterBinding
import com.lyapkov.rickandmorty.mvp.model.image.IImageLoader
import com.lyapkov.rickandmorty.mvp.presenter.list.ICharacterListPresenter
import com.lyapkov.rickandmorty.mvp.view.list.CharacterItemView
import javax.inject.Inject

class CharactersRVAdapter(val presenter: ICharacterListPresenter) :
    RecyclerView.Adapter<CharactersRVAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(val vb: ItemCharacterBinding) : RecyclerView.ViewHolder(vb.root),
        CharacterItemView {
        override var pos = -1

        override fun setName(text: String) = with(vb) { tvName.text = text }
        override fun setStatus(text: String) = with(vb) { tvStatus.text = text }
        override fun setSpecies(text: String) = with(vb) { tvSpecies.text = text }
        override fun setType(text: String?) = with(vb) { tvType.text = text }
        override fun setGender(text: String?) = with(vb) { tvGender.text = text }
        override fun loadAvatar(url: String) = with(vb) { imageLoader.loadInto(url, ivCharacter) }
    }
}