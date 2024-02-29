package com.example.kevinwu_newsapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.kevinwu_newsapi.databinding.NewDetailFragmentLayoutBinding
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class MainActivity : FragmentActivity() {
    //GET https://newsapi.org/v2/top-headlines?country=us&category={WHATEVER}&apiKey=ce4ed20c98344f5790a3023f767855c1
    private lateinit var binding: NewDetailFragmentLayoutBinding

    fun APICallBusiness(){
        // Setup the url connection and include the headers (aka request property)
        val url = URL("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=ce4ed20c98344f5790a3023f767855c1")
        val connection = url.openConnection() as HttpsURLConnection
        connection.setRequestProperty("Accept", "application/geo+json;version=1");
        connection.setRequestProperty("User-Agent", "newsapi.org (kevwu25@bu.edu)");
        connection.connect();

        // Start streaming in data from url connection and print out
        val apiResponse = connection.content as InputStream
        val reader = BufferedReader(apiResponse.reader())
        val content: String = reader.readText()
        Log.v("API", content)

        reader.close()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frag = Business.newInstance("asdasd")
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView2, frag)
            .commit()

        // Inflate the layout using View Binding
        binding = NewDetailFragmentLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.showApi.setOnClickListener {
            Log.v("Yo","Yo")
            Thread { APICallBusiness() }.start()
        }

    }
}



