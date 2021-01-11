package m.woong.giphyapp.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import m.woong.giphyapp.R
import m.woong.giphyapp.databinding.FragmentSearchBinding
import m.woong.giphyapp.ui.BaseFragment
import m.woong.giphyapp.ui.adapter.SearchAdapter

@AndroidEntryPoint
class SearchFragment : BaseFragment() {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private val adapter = SearchAdapter()
    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.searchVm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        val query = savedInstanceState?.getString(LAST_SEARCH_QUERY) ?: DEFAULT_QUERY
        search(query)
        initSearch(query)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAST_SEARCH_QUERY, binding.etSearch.text.trim().toString())
    }

    private fun initAdapter() {
        binding.rvSearch.adapter = adapter
    }

    private fun initSearch(query: String) {
        binding.etSearch.run {
            this.setText(query)

            this.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    updateGiphyListFromInput()
                    true
                } else {
                    false
                }
            }
            this.setOnKeyListener { _, keyCode, event ->
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    updateGiphyListFromInput()
                    true
                } else {
                    false
                }
            }

            /*lifecycleScope.launch {
                adapter.loadStateFlow
                    .distinctUntilChangedBy { it.refresh }
                    .filter { it.refresh is LoadState.NotLoading }
                    .collect { binding.list.scrollToPosition(0) }
            }*/
        }

    }

    private fun updateGiphyListFromInput() {
        binding.etSearch.text.trim().let {
            if (it.isNotEmpty()) {
                search(it.toString())
            }
        }
    }

    private fun search(query: String) {
        searchJob?.cancel() // 새로운 job을 시작하기 위해 이전 Job을 Cancel함
        searchJob = lifecycleScope.launch {
            viewModel.searchGiphy(query).collectLatest { // 결과를 collect해서 람다인자로 넘겨줌
                adapter.submitData(it)
            }
        }
    }

    companion object {
        val TAG: String = SearchFragment::class.java.simpleName
        private const val LAST_SEARCH_QUERY: String = "last_search_query"
        private const val DEFAULT_QUERY = "Apple"

    }
}