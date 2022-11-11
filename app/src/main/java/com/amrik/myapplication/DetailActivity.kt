package com.amrik.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {
    private lateinit var categoryImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        categoryImage=findViewById<ImageView>(R.id.image)
        val url = "https://dummyjson.com/image/i/products/11/3.jpg"
        Picasso.with(this).load(url).into(categoryImage)
        findViewById<TextView>(R.id.tv_title).text =  intent.getStringExtra("title")
       findViewById<TextView>(R.id.tv_brand).text = intent.getStringExtra("brand")
       findViewById<TextView>(R.id.tv_rating).text = intent.getStringExtra("rating")
       findViewById<TextView>(R.id.tv_decription).text =  intent.getStringExtra("description")

    }
}