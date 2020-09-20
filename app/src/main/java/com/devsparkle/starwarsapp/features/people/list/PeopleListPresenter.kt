package com.devsparkle.starwarsapp.features.people.list

import com.devsparkle.starwarsapp.domain.interactor.PeopleInteractor
import com.devsparkle.starwarsapp.features.base.BasePresenter
import javax.inject.Inject

class PeopleListPresenter @Inject constructor(
    var view: PeopleListContract.View, var interactor: PeopleInteractor
) : BasePresenter(), PeopleListContract.Presenter {


    override fun fetchPeoples() {
        verifyConnection(
            { isConnected ->
                view.showLoading()
                if (isConnected) {

                    fetch(interactor.fetchAllPeople(),
                        {
                            view.hideLoading()
                            view.showPeoples(it)
                        }, {
                            view.hideLoading()
                            it.message?.let { msg -> view.showError(msg) }
                        })
                } else {
                    // if not connected propose retry
                    view.proposeRetryFetchPeople()
                }
            }, {
                view.hideLoading()
                it.message?.let { msg -> view.showError(msg) }
            })

    }


    override fun refreshPeoples() {
        verifyConnection(
            { isConnected ->
                if (isConnected) {
                    fetch(interactor.fetchAllPeople(),
                        {
                            view.hideLoading()
                            view.showPeoples(it)
                        }, {
                            view.hideLoading()
                            it.message?.let { msg -> view.showError(msg) }
                        })
                } else {
                    // if not connected propose retry
                    view.proposeRetryFetchPeople()
                }
            }, {
                view.hideLoading()
                it.message?.let { msg -> view.showError(msg) }
            })
    }


}