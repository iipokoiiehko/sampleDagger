package ru.iipokoiiehko.rickandmorty_feature.screen

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_rick_and_morty.view.*
import ru.iipokoiiehko.dagger2sample.presentation.utils.inflate
import ru.iipokoiiehko.rickandmorty_feature.R

class RickAndMortyAdapter :
    ListAdapter<String, RickAndMortyAdapter.RickAndMortyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder {
        return RickAndMortyViewHolder(parent.inflate(R.layout.list_item_rick_and_morty, false))
    }

    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RickAndMortyViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(str: String) {
            containerView.character.text = str
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}