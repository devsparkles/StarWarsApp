package com.devsparkle.starwarsapp.features.people.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devsparkle.starwarsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleListActivity : AppCompatActivity(), PeopleListContract.View {

    lateinit var presenter: PeopleListContract.Presenter




    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = PeopleListPresenter(this )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)

    }




    override fun showPeoples() {
        TODO("Not yet implemented")
    }


}