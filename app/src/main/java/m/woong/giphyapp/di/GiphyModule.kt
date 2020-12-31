package m.woong.giphyapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import m.woong.giphyapp.data.repos.GiphyRepository
import m.woong.giphyapp.data.repos.GiphyRepositoryImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class GiphyModule {

    @Binds
    abstract fun bindGiphyRepository(
        giphyRepositoryImpl: GiphyRepositoryImpl
    ): GiphyRepository

}