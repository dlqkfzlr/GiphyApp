package m.woong.giphyapp.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import m.woong.giphyapp.R
import m.woong.giphyapp.ui.adapter.SearchRvAdapter


/* Snackbar */
fun View.showSnackbar(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).also { sb ->
        sb.setAction("OK") {
            sb.dismiss()
        }
    }.show()
}

/* ImageView */
@BindingAdapter("url")
fun ImageView.setUrl(url: String) {
    Log.d(SearchRvAdapter.TAG, "url:$url")

    url.let {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.ic_error_black_24dp)
            .into(this)
    }
}