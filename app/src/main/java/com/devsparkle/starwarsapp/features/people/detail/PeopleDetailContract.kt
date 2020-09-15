package com.devsparkle.starwarsapp.features.people.detail



interface PeopleDetailContract {

    interface View  {

        fun showPeoples()

    }

    interface Presenter  {

        fun retryPeoples()

        fun fetchPeoples()
    }


}