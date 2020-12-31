package m.woong.giphyapp.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import m.woong.giphyapp.data.repos.GiphyRepository
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import m.woong.giphyapp.data.source.remote.wrapper.ResWrapper
import m.woong.giphyapp.utils.Event

class SearchViewModel @ViewModelInject constructor(
    private val giphyRepository: GiphyRepository
) : ViewModel() {

    private val _searchResponse: MutableLiveData<Event<RemoteSearchGiphyResponse>> by lazy {
        MutableLiveData<Event<RemoteSearchGiphyResponse>>()
    }
    val searchResponse: LiveData<Event<RemoteSearchGiphyResponse>>
        get() = _searchResponse

    private val _networkAvailable: MutableLiveData<Event<Boolean>> by lazy {
        MutableLiveData<Event<Boolean>>()
    }
    val networkAvailable: LiveData<Event<Boolean>>
        get() = _networkAvailable

    fun fetchSearchedGiphy(query: String, offset: Int) {
        viewModelScope.launch {
            Log.d(SearchFragment.TAG, "query: $query")
            val response = giphyRepository.requestToSearchGiphy(query, 10, offset)
            Log.d(SearchFragment.TAG, "response: $response")

            if (response is ResWrapper.Success) {
                _searchResponse.value = Event(response.value)
            } else {
                _networkAvailable.value = Event(false)
            }
        }
    }
}