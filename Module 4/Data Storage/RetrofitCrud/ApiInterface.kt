package RetrofitCrud

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface
{
        @FormUrlEncoded
        @POST("insert.php")
        fun insertdata(
            @Field("product_name")product_name:String,
            @Field("product_price")product_price:String
    ):Call<Void>

        @GET("view.php")
        fun viewdata():Call<List<Model>>

        @FormUrlEncoded
        @POST("delete.php")
        fun deletedata(
            @Field("product_id")product_id:Int
        ):Call<Model>

        @FormUrlEncoded
       @POST("update.php")
       fun updatedata(
            @Field("product_id")product_id:Int,
            @Field("product_name")product_name:String,
            @Field("product_price")product_price:String
       ):Call<Void>
}