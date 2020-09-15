package com.devsparkle.starwarsapp.di.features.people.list


import android.app.Activity
import com.devsparkle.starwarsapp.data.local.AppDatabase
import com.devsparkle.starwarsapp.data.mapper.PeopleResponse2DomainMapper
import com.devsparkle.starwarsapp.data.remote.PeopleService
import com.devsparkle.starwarsapp.data.repository.remote.PeopleRemoteRepository
import com.devsparkle.starwarsapp.domain.interactor.PeopleInteractor
import com.devsparkle.starwarsapp.domain.repository.IPeopleRemoteRepository
import com.devsparkle.starwarsapp.features.people.list.PeopleListActivity
import com.devsparkle.starwarsapp.features.people.list.PeopleListContract
import com.devsparkle.starwarsapp.features.people.list.PeopleListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
abstract class PeopleListModule {

    @Binds
    abstract fun bindActivity(activity: PeopleListActivity): PeopleListContract.View

    @Binds
    abstract fun bindPresenter(impl: PeopleListPresenter): PeopleListContract.Presenter

}


@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule {

    @Provides
    fun bindActivity(activity: Activity): PeopleListActivity {
        return activity as PeopleListActivity
    }
}

@Module
@InstallIn(ActivityComponent::class)
object PeoplePresenterModule {


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
