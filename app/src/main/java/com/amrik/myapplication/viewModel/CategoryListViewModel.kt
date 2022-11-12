package com.amrik.myapplication.viewModel
import android.util.Log
import androidx.lifecycle.ViewModel
import com.amrik.myapplication.Product
import com.amrik.myapplication.api.ApiClient
import com.amrik.myapplication.listener.FailureListener
import com.amrik.myapplication.listener.SuccessListener
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryListViewModel  : ViewModel(){
    val categoryList = ArrayList<Product>()
    val categoryImageList = ArrayList<String>()
    fun getAllCategory(successListener: SuccessListener, failureListener: FailureListener) {
        ApiClient.getCategoryListApi().getCategories().enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val jsonObject = JSONObject(it.string())
                        categoryList.clear()
                        var item: JSONObject
                        for (index in 0 until jsonObject.getJSONArray("products").length()) {
                            item = jsonObject.getJSONArray("products").getJSONObject(index)
                            Log.d(" product.title",""+ item.getString("title"))

                            var jsonArray = item.getJSONArray("images")
                            val imagesList = ArrayList<String>()
                            if (jsonArray != null) {
                                //Iterating JSON array
                                for (i in 0 until jsonArray.length()) {
                                    //Adding each element of JSON array into ArrayList
                                    imagesList.add(jsonArray.get(i).toString())
                                }
                            }
                            categoryList.add(
                                Product(
                                    id = item.getInt("id"),
                                    title = item.getString("title"),
                                    description = item.getString("description"),
                                    discountPercentage = item.getDouble("discountPercentage"),
                                    price = item.getInt("discountPercentage"),
                                    stock = item.getInt("discountPercentage"),
                                    rating = item.getDouble("rating"),
                                    thumbnail = item.getString("thumbnail"),
                                    images = imagesList)
                            )
                        }

                    }
                    successListener.onSuccess("Success")
                } else {
                    failureListener.onFailure("Please try again")
                }}


            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                failureListener.onFailure("Please try again")
            }



        })
    }



}
