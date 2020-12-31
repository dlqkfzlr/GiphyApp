package m.woong.giphyapp

import android.app.Application
import android.content.Context

class GiphyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        private var context: Context? = null
        /*var appContext: Context? = null
            private set*/
    }
}