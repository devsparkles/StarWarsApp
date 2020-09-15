package com.devsparkle.starwarsapp.di.features.people.list

import com.devsparkle.starwarsapp.data.local.AppDatabase
import com.devsparkle.starwarsapp.data.mapper.PeopleResponse2DomainMapper
import com.devsparkle.starwarsapp.data.remote.PeopleService
import com.devsparkle.starwarsapp.data.repository.remote.PeopleRemoteRepository
import com.devsparkle.starwarsapp.domain.interactor.PeopleInteractor
import com.devsparkle.starwarsapp.domain.repository.IPeopleRemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object PeopleListModule {


    @Provides
    fun provideCharacterService(retrofit: Retrofit): PeopleService =
        retrofit.create(PeopleService::class.java)


    @Provides
    fun providePeopleDao(db: AppDatabase) = db.peopleDao()

    @Provides
    fun providePeopleRepository(
        peopleService: PeopleService,
        mapper: PeopleResponse2DomainMapper
    ): IPeopleRemoteRepository =
        PeopleRemoteRepository(
            peopleService,
            mapper
        )


    @Provides
    fun providePeopleInteractor(
        peopleInteractor: PeopleRemoteRepository
    ): PeopleInteractor {
        return PeopleInteractor(
            peopleInteractor
        )
    }

}
