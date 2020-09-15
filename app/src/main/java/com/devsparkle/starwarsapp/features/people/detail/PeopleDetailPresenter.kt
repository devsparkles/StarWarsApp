package com.devsparkle.starwarsapp.features.people.detail

import com.devsparkle.starwarsapp.domain.interactor.PeopleInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PeopleDetailPresenter constructor(private var view: PeopleDetailContract.View,
                                              ) : PeopleDetailContract.Presenter {

    @Inject lateinit var interactor: PeopleInteractor

    private val compositeDisposable = CompositeDisposable()

    override fun fetchPeoples() {
        TODO("Not yet implemented")
    }

    override fun retryPeoples() {
        TODO("Not yet implemented")
    }
}
