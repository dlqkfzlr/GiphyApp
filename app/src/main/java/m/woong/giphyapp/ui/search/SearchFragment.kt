package m.woong.giphyapp.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import m.woong.giphyapp.R
import m.woong.giphyapp.databinding.FragmentSearchBinding
import m.woong.giphyapp.ui.BaseFragment
import m.woong.giphyapp.ui.adapter.SearchRvAdapter
import m.woong.giphyapp.utils.showSnackbar

@AndroidEntryPoint
class SearchFragment : BaseFragment() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchRvAdapter: SearchRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.searchVm = searchViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        searchRvAdapter = SearchRvAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSearch.adapter = searchRvAdapter

        searchViewModel.searchClicked.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                hideSoftKeyboard(binding.etSearch)
            }
        })

        searchViewModel.searchResponse.observe(viewLifecycleOwner,
            Observer { it ->
                it.getContentIfNotHandled()?.let { response ->
                    Log.d(TAG, "downsized:${response.data[0].images.downsized.url}")
                    Log.d(TAG, "previewGif:${response.data[0].images.previewGif.url}")
                    searchRvAdapter.setData(response.data.map { data ->  data.images.previewGif })
                }
            })

        searchViewModel.networkAvailable.observe(viewLifecycleOwner,
            Observer {
                it.getContentIfNotHandled()?.let { available ->
                    if (!available) {
                        binding.rootSearch.showSnackbar(resources.getString(R.string.network_not_available))
                    }
                }
            })

        binding.etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchGiphy(binding.etSearch)
                true
            } else {
                false
            }
        }
    }

    private fun searchGiphy(et: EditText) {
        searchViewModel.searchGiphy()
    }

    companion object {
        val TAG: String = SearchFragment::class.java.simpleName
    }
}