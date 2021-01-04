package m.woong.giphyapp.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import m.woong.giphyapp.R


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
    url.let {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .error(R.drawable.ic_error_black_24dp)
            .into(this)
    }
}