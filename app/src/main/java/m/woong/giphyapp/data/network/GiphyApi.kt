package m.woong.giphyapp.data.network

import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {

    @GET(SUB_PATH_SEARCH)
    suspend fun requestToSearchGiphy(
        @Query("api_key") key: String = API_KEY,
        @Query("q") q: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("offset") rating: String = "g",
        @Query("offset") lang: String = "en"
    ): RemoteSearchGiphyResponse

    companion object {
        const val API_KEY = "CAvlc5ArNMyF9U0dbm1XJ64TFS6DMsUB"
        const val SUB_PATH_SEARCH = "/search"
        const val SUB_PATH_TREND = "/trending"
    }
}