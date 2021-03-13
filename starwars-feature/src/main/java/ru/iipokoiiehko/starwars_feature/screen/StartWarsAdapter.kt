package ru.iipokoiiehko.starwars_feature.screen

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_star_wars.view.*
import ru.iipokoiiehko.dagger2sample.presentation.utils.inflate
import ru.iipokoiiehko.starwars_feature.R

class StartWarsAdapter :
    ListAdapter<String, StartWarsAdapter.StartWarsViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartWarsViewHolder {
        return StartWarsViewHolder(parent.inflate(R.layout.list_item_star_wars, false))
    }

    override fun onBindViewHolder(holder: StartWarsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class StartWarsViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(str: String) {
            containerView.people.text = str
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