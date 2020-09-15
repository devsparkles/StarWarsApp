package com.devsparkle.starwarsapp.domain.repository

import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import io.reactivex.Single

interface IPeopleRemoteRepository {

    /**
     * Fetch all people ( the first page )
     */
    fun fetchAllPeople(): Single<List<PeopleDTO>>
}

