package m.woong.giphyapp.ui.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import m.woong.giphyapp.data.repos.GiphyRepository
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse.Data.Images.PreviewGif

class SearchViewModel @ViewModelInject constructor(
    private val repository: GiphyRepository
) : ViewModel() {

    // two-way databinding
    val queryString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<PreviewGif>>? = null
    /*private val _searchClicked: MutableLiveData<Event<Boolean>> by lazy {
        MutableLiveData<Event<Boolean>>()
    }
    val searchClicked: LiveData<Event<Boolean>>
        get() = _searchClicked

    private val _searchResponse: MutableLiveData<Event<PreviewGif>> by lazy {
        MutableLiveData<Event<PreviewGif>>()
    }
    val searchResponse: LiveData<Event<PreviewGif>>
        get() = _searchResponse

    private val _networkAvailable: MutableLiveData<Event<Boolean>> by lazy {
        MutableLiveData<Event<Boolean>>()
    }
    val networkAvailable: LiveData<Event<Boolean>>
        get() = _networkAvailable*/

    /*fun searchGiphy() {
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
    }*/

    fun searchGiphy(query: String): Flow<PagingData<PreviewGif>> {
        val lastResult = currentSearchResult
        if(query == currentQueryValue && lastResult != null) return lastResult
        currentQueryValue = query
        val newResult: Flow<PagingData<PreviewGif>> = repository.getSearchResultStream(query)
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}