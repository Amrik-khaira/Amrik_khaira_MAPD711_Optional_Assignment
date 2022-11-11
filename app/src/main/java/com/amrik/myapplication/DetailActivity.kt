package com.amrik.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent

        findViewById<TextView>(R.id.tv_title).text =  intent.getStringExtra("title")
       findViewById<TextView>(R.id.tv_brand).text = intent.getStringExtra("brand")
       findViewById<TextView>(R.id.tv_rating).text = intent.getStringExtra("rating")
       findViewById<TextView>(R.id.tv_decription).text =  intent.getStringExtra("description")

    }
}