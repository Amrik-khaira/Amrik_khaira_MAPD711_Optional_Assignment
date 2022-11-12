package com.amrik.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.amrik.myapplication.adapter.ImagesAdapter
import com.google.gson.Gson
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {
    private lateinit var categoryImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Activity"
        val intent = intent
        val imagesList = intent.getStringArrayListExtra("images")
        Log.e("images----", Gson().toJson(imagesList) )
        findViewById<TextView>(R.id.tv_title).text =  intent.getStringExtra("title")
        findViewById<TextView>(R.id.tv_brand).text = intent.getStringExtra("brand")
        findViewById<TextView>(R.id.tv_rating).text = intent.getDoubleExtra("rating",0.0).toString()
        findViewById<TextView>(R.id.tv_decription).text =  intent.getStringExtra("description")

        val viewPage = findViewById<ViewPager>(R.id.viewPage)

        val adapterView = ImagesAdapter(this, imagesList!!)
        viewPage.adapter = adapterView

    }
}