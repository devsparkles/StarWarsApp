package com.devsparkle.starwarsapp.features.people.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.devsparkle.starwarsapp.R
import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_people_detail.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class PeopleDetailActivity : AppCompatActivity(), PeopleDetailContract.View {

    @Inject
    lateinit var presenter: PeopleDetailContract.Presenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_detail)
        setSupportActionBar(people_detail_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val people = intent.extras?.getParcelable<PeopleDTO>("people")
        people?.let {
            people_detail_toolbar.title = it.name
            people_name.text = it.name
            people_height.text = getString(R.string.people_mass, it.height)
            people_mass.text = getString(R.string.people_mass, it.mass)

            val pattern = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(pattern, Locale.UK)
            val created: String = simpleDateFormat.format(people.created)
            people_created.text = created
        }


    }

    override fun onBackPressed() {
        //super.onBackPressed()
        finish()
    }


}