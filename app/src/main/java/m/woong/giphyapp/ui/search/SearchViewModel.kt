package m.woong.giphyapp.ui.search

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import m.woong.giphyapp.data.repos.GiphyRepository
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import m.woong.giphyapp.data.source.remote.wrapper.ResWrapper
import m.woong.giphyapp.utils.Event

class SearchViewModel @ViewModelInject constructor(
    private val giphyRepository: GiphyRepository
) : ViewModel() {

    // two-way databinding
    val queryData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val _searchClicked: MutableLiveData<Event<Boolean>> by lazy {
        MutableLiveData<Event<Boolean>>()
    }
    val searchClicked: LiveData<Event<Boolean>>
        get() = _searchClicked

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

    fun searchGiphy() {
        _searchClicked.value = Event(true)
        if (queryData.value.isNullOrBlank()) return
        viewModelScope.launch {
            val response = giphyRepository.requestToSearchGiphy(queryData.value.toString(), 10, 0)
//            Log.d(SearchFragment.TAG, "response: $response")

            if (response is ResWrapper.Success) {
                _searchResponse.value = Event(response.value)
            } else {
                _networkAvailable.value = Event(false)
            }
//            withContext(Dispatchers)
        }
    }
}