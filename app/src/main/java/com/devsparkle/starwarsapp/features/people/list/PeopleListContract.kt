package com.devsparkle.starwarsapp.features.people.list



interface PeopleListContract {

    interface View  {

        fun showPeoples()

    }

    interface Presenter  {

        fun retryPeoples()

        fun fetchPeoples()
    }


}