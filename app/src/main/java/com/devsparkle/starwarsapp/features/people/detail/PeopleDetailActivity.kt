package com.devsparkle.starwarsapp.features.people.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devsparkle.starwarsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailActivity : AppCompatActivity(), PeopleDetailContract.View {

    lateinit var presenter: PeopleDetailContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        presenter = PeopleDetailPresenter(this )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)

    }


    override fun showPeoples() {
        TODO("Not yet implemented")
    }


}