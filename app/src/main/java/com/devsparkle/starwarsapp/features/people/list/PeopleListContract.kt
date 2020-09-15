package com.devsparkle.starwarsapp.features.people.list

import com.devsparkle.starwarsapp.domain.model.PeopleDTO


interface PeopleListContract {

    interface View {

        /***
         *
         */
        fun showPeoples(list: List<PeopleDTO>)

        /**
         *
         */
        fun showError(message: String)

        /***
         *
         */
        fun hideLoading()

        /***
         *
         */
        fun showLoading()

        /***
         *
         */
        fun showNotConnected()

        /***
         *
         */
        fun proposeRetryFetchPeople()



    }

    interface Presenter {

        /***
         * Get list of peoples
         */
        fun fetchPeoples()
    }


}