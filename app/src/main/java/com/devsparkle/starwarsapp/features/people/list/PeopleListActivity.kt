package com.devsparkle.starwarsapp.features.people.list

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devsparkle.starwarsapp.R
import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_people_list.*
import javax.inject.Inject

@AndroidEntryPoint
class PeopleListActivity : AppCompatActivity(), PeopleListContract.View {


    @Inject
    lateinit var presenter: PeopleListContract.Presenter

    var adapter = PeopleListAdapter(mutableListOf<PeopleDTO>())

    private lateinit var peopleList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)
        peopleList = people_list
        peopleList.setHasFixedSize(true)
        peopleList.adapter = adapter
        peopleList.layoutManager = LinearLayoutManager(this@PeopleListActivity)
        presenter.fetchPeoples()


        btn_retry.setOnClickListener {
            presenter.fetchPeoples()
        }


        swipe_to_refresh.setOnRefreshListener {
            presenter.refreshPeoples()
        }

    }

    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(productDisplayDTO: PeopleDTO)
    }


    override fun showPeoples(list: List<PeopleDTO>) {
        propose_retry.visibility = View.GONE
        progress_bar.visibility = View.GONE
        people_list.visibility = View.VISIBLE

        adapter.setPeoples(list)
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        Snackbar.make(main_list_people_view, message, Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun hideLoading() {
        propose_retry.visibility = View.GONE
        people_list.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
        swipe_to_refresh.isRefreshing = false
    }

    override fun showLoading() {
        propose_retry.visibility = View.GONE
        people_list.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
    }

    override fun showNotConnected() {
        propose_retry.visibility = View.VISIBLE
        people_list.visibility = View.GONE
        progress_bar.visibility = View.GONE
        Snackbar.make(main_list_people_view, R.string.not_connected, Snackbar.LENGTH_SHORT)
            .show()
    }

    override fun proposeRetryFetchPeople() {
        propose_retry.visibility = View.VISIBLE
        people_list.visibility = View.GONE
        progress_bar.visibility = View.GONE
    }
}