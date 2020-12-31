package m.woong.giphyapp.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar


/* Snackbar */
fun View.showSnackbar(msg: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).also { sb ->
        sb.setAction("OK") {
            sb.dismiss()
        }
    }.show()
}