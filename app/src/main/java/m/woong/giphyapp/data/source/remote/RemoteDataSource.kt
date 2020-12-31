package m.woong.giphyapp.data.source.remote

import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse

interface RemoteSource {

    suspend fun requestToSearchGiphy(q: String, limit: Int, offset: Int): RemoteSearchGiphyResponse

}