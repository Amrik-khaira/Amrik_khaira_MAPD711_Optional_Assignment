package com.amrik.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrik.myapplication.adapter.CategoryListAdapter

import com.amrik.myapplication.listener.FailureListener
import com.amrik.myapplication.listener.ItemSelectListener
import com.amrik.myapplication.listener.SuccessListener
import com.amrik.myapplication.viewModel.CategoryListViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryListAdapter: CategoryListAdapter
    private lateinit var viewModel: CategoryListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "List Activity"
        viewModel = ViewModelProvider(this).get(CategoryListViewModel::class.java)
        initUi()


    }
    private fun initUi() {
        recyclerView = findViewById(R.id.rv_category)
        getCategoryList()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun setAdapter() {
        categoryListAdapter =
            CategoryListAdapter(context = this,
                itemSelectListener = object : ItemSelectListener {
                    override fun onItemSelect(item: Any) {
                        var product = item as Product
                        val intent = Intent(applicationContext, DetailActivity::class.java)
                        intent.putExtra("title",product.title)
                        intent.putExtra("brand",product.brand)
                        intent.putExtra("rating",product.rating)
                        intent.putExtra("description",product.description)
                        intent.putExtra("images",product.images)
                        startActivity(intent)

                    }
                }
            )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = categoryListAdapter
        categoryListAdapter.submitList(viewModel.categoryList)
        categoryListAdapter.notifyDataSetChanged()
    }

    private fun getCategoryList() {
        viewModel.getAllCategory(object : SuccessListener {
            override fun onSuccess(obj: Any) {
                setAdapter()

            }
        }, object : FailureListener {
            @SuppressLint("SetTextI18n")
            override fun onFailure(obj: Any) {

            }
        })
    }


}
