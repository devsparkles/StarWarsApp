package com.devsparkle.starwarsapp.domain.interactor

import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import com.devsparkle.starwarsapp.domain.repository.IPeopleRemoteRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * This layer exist in case we want to combine several remote or local repositories
 */
class PeopleInteractor @Inject constructor(
    private val peopleRemoteRepository: IPeopleRemoteRepository
) {

    fun fetchAllPeople(): Single<List<PeopleDTO>> {
        return peopleRemoteRepository.fetchAllPeople()
    }
}
