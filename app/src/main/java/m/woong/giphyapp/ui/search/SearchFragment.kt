package m.woong.giphyapp.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import m.woong.giphyapp.R
import m.woong.giphyapp.databinding.FragmentSearchBinding
import m.woong.giphyapp.ui.BaseFragment
import m.woong.giphyapp.utils.showSnackbar
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : BaseFragment() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.searchVm = searchViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.searchResponse.observe(viewLifecycleOwner,
        Observer {
            it.getContentIfNotHandled()?.let { response ->
                Log.d(TAG, "개수: ${response.data.size}")
            }
        })

        searchViewModel.networkAvailable.observe(viewLifecycleOwner,
        Observer {
            it.getContentIfNotHandled()?.let { available ->
                if (!available){
                    binding.rootSearch.showSnackbar(resources.getString(R.string.network_not_available))
                }
            }
        })

        binding.etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (!v.text.isNullOrBlank()) {
                    hideSoftKeyboard(binding.etSearch)
                    searchViewModel.fetchSearchedGiphy(v.text.toString(), 0)
                }
                true
            } else {
                false
            }
        }
    }

    companion object {
        val TAG = SearchFragment::class.java.simpleName
    }
}