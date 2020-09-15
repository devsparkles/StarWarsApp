package com.devsparkle.starwarsapp.data.remote

import com.devsparkle.starwarsapp.data.remote.response.PeopleResponse
import com.devsparkle.starwarsapp.data.remote.response.wrapper.WrapperResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface PeopleService {

    @GET("people/")
    fun getPeoples(): Single<WrapperResponse<PeopleResponse>>

    @GET
    fun getPeoplesNextPage(@Url url: String): Single<WrapperResponse<PeopleResponse>>

    @GET
    fun getPeopleDetail(@Url url: String): Single<PeopleResponse>

}