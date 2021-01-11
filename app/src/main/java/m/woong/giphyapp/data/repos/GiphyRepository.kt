package m.woong.giphyapp.data.repos

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import m.woong.giphyapp.data.source.remote.wrapper.ResWrapper

interface GiphyRepository {

    suspend fun requestToSearchGiphy(q: String, limit: Int, offset: Int): ResWrapper<RemoteSearchGiphyResponse>
    fun getSearchResultStream(query: String): Flow<PagingData<RemoteSearchGiphyResponse.Data.Images.PreviewGif>>
}