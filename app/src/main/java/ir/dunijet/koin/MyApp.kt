package ir.dunijet.koin

import android.app.Application
import android.widget.ImageView
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module



interface ImageLoaderService{
    fun loadImage(url:String,imageView: ImageView)
}
class PicassoLoader:ImageLoaderService{
    override fun loadImage(url: String, imageView: ImageView) {
      Picasso.get().load(url).into(imageView)
    }

}

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        val myModule= module {
            factory<ImageLoaderService> {PicassoLoader()  }

        }

        startKoin {
            androidContext(this@MyApp)
            modules(myModule)
        }
    }
}