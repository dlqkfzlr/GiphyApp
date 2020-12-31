package m.woong.giphyapp.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import m.woong.giphyapp.data.network.GiphyApi
import m.woong.giphyapp.data.repos.GiphyRepository
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Singleton
    @Provides
    fun provideGiphyApi(@ApplicationContext context: Context): GiphyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .cache(Cache(context.cacheDir, 10*1024*1024))
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GiphyApi::class.java)
    }

    @Binds
    abstract fun bindGiphyRepository(
        giphyRepositoryImpl: GiphyRepository
    ): GiphyRepository

    companion object {
        const val BASE_URL = "https://api.giphy.com/v1/gifs"
    }
}