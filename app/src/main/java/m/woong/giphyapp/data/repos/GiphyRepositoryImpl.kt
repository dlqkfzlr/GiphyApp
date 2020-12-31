package m.woong.giphyapp.data.repos

import m.woong.giphyapp.data.source.remote.RemoteDataSourceImpl
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
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
}