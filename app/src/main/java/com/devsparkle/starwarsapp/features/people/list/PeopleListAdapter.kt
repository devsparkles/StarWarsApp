package com.devsparkle.starwarsapp.features.people.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devsparkle.starwarsapp.R
import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import kotlinx.android.synthetic.main.list_item_people.view.*
import java.text.SimpleDateFormat
import java.util.*

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
        holder.mPeopleHeight.text = people.height + " cm"
        holder.mMass.text = people.mass + " kg"

        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        if(people.created is Date){
            val date: String = simpleDateFormat.format(people.created)
            holder.mCreated.text =date

        }


        with(holder.mView) {
            tag = people
        }
    }

    fun setPeoples(list: List<PeopleDTO>){
        mDataset.clear()
        mDataset.addAll(list)
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mName: TextView = mView.people_name
        val mPeopleHeight: TextView = mView.people_height
        val mMass: TextView = mView.people_mass
        val mCreated: TextView = mView.people_created
    }
}