package m.woong.giphyapp.data.repos

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import m.woong.giphyapp.data.source.paging.GiphyPagingSource
import m.woong.giphyapp.data.source.remote.RemoteDataSourceImpl
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse.Data.Images.PreviewGif
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSourceImpl
): BaseRepository(), GiphyRepository {

    override suspend fun requestToSearchGiphy(
        q: String,
        limit: Int,
        offset: Int
    ) = safeApiCall  {
        remoteDataSource.requestToSearchGiphy(q, limit, offset)
    }

    override fun getSearchResultStream(query: String): Flow<PagingData<PreviewGif>> {
        Log.d("GiphyRepositoryImpl", "New query: $query")
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GiphyPagingSource(remoteDataSource, query) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}