package m.woong.giphyapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import m.woong.giphyapp.R
import m.woong.giphyapp.data.source.remote.model.RemoteSearchGiphyResponse
import m.woong.giphyapp.databinding.RvitemSearchBinding

class SearchRvAdapter() : RecyclerView.Adapter<SearchRvAdapter.ViewHolder>() {

    private val gifList = ArrayList<RemoteSearchGiphyResponse.Data.Images.PreviewGif>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchRvAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<RvitemSearchBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rvitem_search,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(gifList[position])
    }

    override fun getItemCount(): Int = gifList.size


    fun setData(dataList: List<RemoteSearchGiphyResponse.Data.Images.PreviewGif>) {
        gifList.clear()
        gifList.addAll(dataList)
        Log.d(TAG, "setData size:${dataList.size}")
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val searchBinding: RvitemSearchBinding) :
        RecyclerView.ViewHolder(searchBinding.root) {

        fun onBind(previewItem: RemoteSearchGiphyResponse.Data.Images.PreviewGif) {
            searchBinding.apply {
                this.previewItem = previewItem
            }
        }
    }

    companion object {
        val TAG = SearchRvAdapter::class.java.simpleName
    }

}