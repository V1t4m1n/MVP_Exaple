package ua.vitamin.mvp_example

import retrofit2.Call
import retrofit2.http.GET

interface Request {
    @GET("api?results=10")
    public fun getPeople(): Call<List<User>>
}