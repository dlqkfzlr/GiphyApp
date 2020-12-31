package m.woong.giphyapp.data.source.remote.wrapper

import okhttp3.ResponseBody

sealed class ResWrapper<out T> {
    data class Success<out T>(val value: T) : ResWrapper<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?
    ) : ResWrapper<Nothing>()
    object Loading : ResWrapper<Nothing>()
}