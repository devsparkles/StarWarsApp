package com.devsparkle.starwarsapp.data.repository.remote

import com.devsparkle.starwarsapp.data.mapper.PeopleResponse2DomainMapper
import com.devsparkle.starwarsapp.data.remote.PeopleService
import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import com.devsparkle.starwarsapp.domain.repository.IPeopleRemoteRepository
import io.reactivex.Single
import javax.inject.Inject


class PeopleRemoteRepository @Inject constructor(
    private var peopleService: PeopleService,
    private var mapper: PeopleResponse2DomainMapper
) : IPeopleRemoteRepository {

    override fun fetchAllPeople(): Single<List<PeopleDTO>> {
        return peopleService.getPeoples().map {
            it.results.let { listResponse ->
                listResponse.map { mapper.toPeopleDTO(it) }
            }
        }
    }
}