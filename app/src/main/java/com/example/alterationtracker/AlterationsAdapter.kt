package com.example.alterationtracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.example.alterationtracker.databinding.AlterationInfoBinding
import com.example.alterationtracker.databinding.FragmentAlterationListBinding

class AlterationsAdapter(val alterations: ObservableArrayList<Alteration>): RecyclerView.Adapter<AlterationsAdapter.ViewHolder>() {
    class ViewHolder(val binding: AlterationInfoBinding): RecyclerView.ViewHolder(binding.root)


    init {
        alterations.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableArrayList<Alteration>>() {
            override fun onChanged(sender: ObservableArrayList<Alteration>?) {
                notifyDataSetChanged()
            }

            override fun onItemRangeChanged(
                sender: ObservableArrayList<Alteration>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemChanged(positionStart)
            }

            override fun onItemRangeInserted(
                sender: ObservableArrayList<Alteration>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemInserted(positionStart)
            }

            override fun onItemRangeMoved(
                sender: ObservableArrayList<Alteration>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {

            }

            override fun onItemRangeRemoved(
                sender: ObservableArrayList<Alteration>?,
                positionStart: Int,
                itemCount: Int
            ) {
                notifyItemRemoved(positionStart)
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AlterationInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alteration = alterations[position]
        holder.binding.customerName.text = alteration.customerName
        holder.binding.pantAlterations.text = alteration.pantAlterations
        holder.binding.suitAlterations.text = alteration.suitAlterations
    }

    override fun getItemCount(): Int {
        return alterations.size
    }
}