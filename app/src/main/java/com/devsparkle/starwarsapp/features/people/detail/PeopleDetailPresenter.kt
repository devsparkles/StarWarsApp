package com.devsparkle.starwarsapp.features.people.detail

import com.devsparkle.starwarsapp.domain.interactor.PeopleInteractor
import javax.inject.Inject

class PeopleDetailPresenter @Inject constructor(
    private var view: PeopleDetailContract.View,
    var interactor: PeopleInteractor
) : PeopleDetailContract.Presenter
