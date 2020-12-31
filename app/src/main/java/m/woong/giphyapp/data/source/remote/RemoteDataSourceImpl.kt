package m.woong.giphyapp.data.source.remote

import m.woong.giphyapp.data.network.GiphyApi
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: GiphyApi
): RemoteSource {

    override suspend fun requestToSearchGiphy(
        q: String,
        limit: Int,
        offset: Int
    ): RemoteSearchGiphyResponse {
        return api.requestToSearchGiphy(q = q, limit = limit, offset = offset)
    }
}