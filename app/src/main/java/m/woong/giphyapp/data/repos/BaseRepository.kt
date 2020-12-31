package m.woong.giphyapp.data.repos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import m.woong.giphyapp.data.source.remote.wrapper.ResWrapper
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResWrapper<T> {
        return withContext(Dispatchers.IO) {
            try {
                ResWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        ResWrapper.Failure(isNetworkError = false, errorCode = throwable.code(), errorBody = throwable.response()?.errorBody())
                    }
                    else -> {
                        ResWrapper.Failure(true, null, null)
                    }
                }
            }
        }
    }
}