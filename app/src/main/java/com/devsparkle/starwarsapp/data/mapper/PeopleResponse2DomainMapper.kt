package com.devsparkle.starwarsapp.data.mapper

import com.devsparkle.starwarsapp.data.remote.response.PeopleResponse
import com.devsparkle.starwarsapp.domain.model.PeopleDTO
import com.google.gson.Gson
import javax.inject.Inject


open class PeopleResponse2DomainMapper @Inject constructor(val gson: Gson) {

    fun toPeopleDTO(p: PeopleResponse): PeopleDTO {
        return PeopleDTO(
            name = p.name,
            height = p.height,
            mass = p.mass,
            created = p.created
        )
    }
}
