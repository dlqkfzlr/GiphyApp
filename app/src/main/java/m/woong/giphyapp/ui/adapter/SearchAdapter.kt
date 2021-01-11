package m.woong.giphyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import m.woong.giphyapp.R
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse.Data.Images.PreviewGif
import m.woong.giphyapp.databinding.SearchViewItemBinding

class SearchAdapter : PagingDataAdapter<PreviewGif, SearchAdapter.SearchViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        val binding = DataBindingUtil.inflate<SearchViewItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.search_view_item,
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    class SearchViewHolder(private val binding: SearchViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(previewItem: PreviewGif) {
            binding.apply {
                this.previewItem = previewItem
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PreviewGif>() {
            override fun areItemsTheSame(oldItem: PreviewGif, newItem: PreviewGif): Boolean =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: PreviewGif, newItem: PreviewGif): Boolean =
                oldItem == newItem
        }
    }
}