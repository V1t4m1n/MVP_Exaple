package ua.vitamin.mvp_example

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainModel () : Contract.Model {

    private var listPeople: MutableList<User> = mutableListOf()
    private final val TAG: String = this.javaClass.simpleName

    override fun loadList(): List<User> {
        Log.d(TAG, "loadMessage")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Request::class.java)
        val call = service.getPeople()

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.let { listPeople.addAll(it) }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t.printStackTrace()
                t.localizedMessage
            }

        })
        return listPeople
    }
}