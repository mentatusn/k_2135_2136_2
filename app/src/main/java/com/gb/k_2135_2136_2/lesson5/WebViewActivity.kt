package com.gb.k_2135_2136_2.lesson5

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gb.k_2135_2136_2.databinding.ActivityWebviewBinding
import com.gb.k_2135_2136_2.utils.getLines
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


internal class WebViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ok.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
            }
        })
        binding.ok.setOnClickListener{v: View->}
        binding.ok.setOnClickListener{v->}
        binding.ok.setOnClickListener{it} // it == v == v: View
        binding.ok.setOnClickListener{} // само собой == v == v: View

        binding.ok.setOnClickListener {
            binding.url.text.let {

                //binding.webView.loadUrl(it.toString()) // TODO HW можно и без этого всего

                val uri = URL(it.toString())

                var myConnection: HttpURLConnection? = null

                myConnection = uri.openConnection() as HttpURLConnection
                myConnection.readTimeout = 5000
                val handler = Handler(Looper.myLooper()!!)// то же самое что Handler(Looper.getMainLooper()) потому что мы в Activity
                Thread{
                    val reader = BufferedReader(InputStreamReader(myConnection.inputStream))
                    val result = getLines(reader)
                    Log.d("@@@",result)

                    handler.post( object: Runnable {
                        override fun run() {
                            //binding.webView.loadData(result,"text/html; charset=utf-8","utf-8")
                            binding.webView.loadDataWithBaseURL(null,result,"text/html; charset=utf-8","utf-8",null)
                        }
                    })

                }.start()

            }
        }
    }





}

