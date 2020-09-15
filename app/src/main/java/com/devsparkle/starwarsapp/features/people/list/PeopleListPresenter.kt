package com.devsparkle.starwarsapp.features.people.list

import com.devsparkle.starwarsapp.domain.interactor.PeopleInteractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PeopleListPresenter constructor(private var view: PeopleListContract.View,
                                              ) : PeopleListContract.Presenter {

    @Inject lateinit var interactor: PeopleInteractor


    private val compositeDisposable = CompositeDisposable()

    override fun fetchPeoples() {
        TODO("Not yet implemented")
    }

    override fun retryPeoples() {
        TODO("Not yet implemented")
    }
}
