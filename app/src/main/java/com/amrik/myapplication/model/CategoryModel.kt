package  com.amrik.myapplication
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class CategoryModel (
    val products: ArrayList<Product>,
    var total: Long,
    var skip: Long,
    var limit: Long
) : Parcelable

@Parcelize
data class Product (
    var id: Int= -1,
    var title: String ="",
    var description: String,
    var price:Int=-1,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int=-1,
    var brand: String="",
    var category: String="",
    var thumbnail: String="",
   // val images:ArrayList<String>
) : Parcelable
