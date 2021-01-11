package m.woong.giphyapp.data.source.paging

//import androidx.paging.PagingSource
import androidx.paging.PagingSource
import m.woong.giphyapp.api.GiphyApi
import m.woong.giphyapp.data.source.remote.RemoteDataSourceImpl
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse.Data.Images.PreviewGif
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val GIPHY_STARTING_PAGE_INDEX = 1

class GiphyPagingSource (
    private val remoteDataSource: RemoteDataSourceImpl,
    private val query: String
) : PagingSource<Int, PreviewGif>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PreviewGif> {
        val position = params.key ?: GIPHY_STARTING_PAGE_INDEX
        val apiQuery = query
        return try {
            val response = remoteDataSource.requestToSearchGiphy(
                q = apiQuery,
                limit = params.loadSize,
                offset = position
            )
            val repos = response.data.map { it.images.previewGif }
            LoadResult.Page(
                data = repos,
                prevKey = if (position == GIPHY_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (repos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
