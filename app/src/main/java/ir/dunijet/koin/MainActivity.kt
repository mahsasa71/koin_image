package ir.dunijet.koin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val imageLoaderService: ImageLoaderService by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val url = "https://files.namnak.com/users/nh/aup/202103/1465_pics/%D8%B9%D8%B7%D8%B1-%D8%B9%D8%B3%D9%84.jpg"
            val imageview = findViewById<ImageView>(R.id.imageView)
            imageLoaderService.loadImage(url, imageview)

        }catch (e:Exception){

            Log.v("data32",e.toString())


        }
    }
}