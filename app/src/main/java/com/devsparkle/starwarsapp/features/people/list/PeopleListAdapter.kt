package com.devsparkle.starwarsapp.features.people.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devsparkle.starwarsapp.R
import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import com.devsparkle.starwarsapp.features.people.detail.PeopleDetailActivity
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.list_item_people.view.*

class PeopleListAdapter constructor(
    private val mDataset: MutableList<PeopleDTO>
) : RecyclerView.Adapter<PeopleListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_people, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val people = mDataset[position]

        holder.mName.text = people.name
        holder.mCardView.setOnClickListener { v ->
            val intent = Intent(v.context, PeopleDetailActivity::class.java)
            intent.putExtra("people", people)
            v.context.startActivity(intent)
        }



        with(holder.mView) {
            tag = people
        }
    }

    fun setPeoples(list: List<PeopleDTO>) {
        mDataset.clear()
        mDataset.addAll(list)
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mName: TextView = mView.name
        val mCardView: MaterialCardView = mView.materialCardRow
    }
}