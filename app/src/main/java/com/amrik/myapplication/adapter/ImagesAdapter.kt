package com.amrik.myapplication.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso

class ImagesAdapter(var mContext: Context?, var imagesList: ArrayList<String>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ImageView
    }
    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val imageView = ImageView(mContext)
        val url = imagesList[position]
        Picasso.with(mContext).load(url).into(imageView)
        (container as ViewPager).addView(imageView, 0)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as ImageView)
    }

    override fun getCount(): Int {
        return imagesList.size
    }
}

